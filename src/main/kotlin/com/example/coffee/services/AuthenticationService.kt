package com.example.coffee.services

import com.example.coffee.configurations.JwtProperties
import com.example.coffee.repositories.AuthenticationResponse
import com.example.coffee.repositories.RefreshTokenRepository
import com.example.coffee.repositories.UserRepository
import com.example.coffee.requests.AuthenticationRequest
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthenticationService(
    private val authManager: AuthenticationManager,
    private val userDetailsService: CustomUserDetailsService,
    private val userRepository: UserRepository,
    private val tokenService: TokenService,
    private val refreshTokenRepository: RefreshTokenRepository,
    private val jwtProperties: JwtProperties,
) {

    fun authentication(authenticationRequest: AuthenticationRequest): AuthenticationResponse {
        authManager.authenticate(
            UsernamePasswordAuthenticationToken(
                authenticationRequest.email,
                authenticationRequest.password
            )
        )
        val userDetails = userDetailsService.loadUserByUsername(authenticationRequest.email)
        val user = userRepository.findByEmail(authenticationRequest.email)
        val accessToken = createAccessToken(userDetails)
        val refreshToken = createRefreshToken(userDetails)
        refreshTokenRepository.save(refreshToken, userDetails)
        return AuthenticationResponse(
            email = user?.email,
            role = user?.role,
            name = user?.name,
            accessToken = accessToken,
            refreshToken = refreshToken
        )
    }
    fun refreshAccessToken(refreshToken: String): String? {
        val extractedEmail = tokenService.extractEmail(refreshToken)
        return extractedEmail?.let { email ->
            val currentUserDetails = userDetailsService.loadUserByUsername(email)
            val refreshTokenUserDetails = refreshTokenRepository.findUserDetailsByToken(refreshToken)
            if (!tokenService.isExpired(refreshToken) && refreshTokenUserDetails?.username == currentUserDetails.username)
                createAccessToken(currentUserDetails)
            else
                null
        }
    }
    private fun createAccessToken(user: UserDetails) = tokenService.generate(
        userDetails = user,
        expirationDate = getAccessTokenExpiration()
    )
    private fun createRefreshToken(user: UserDetails) = tokenService.generate(
        userDetails = user,
        expirationDate = getRefreshTokenExpiration()
    )
    private fun getAccessTokenExpiration(): Date =
        Date(System.currentTimeMillis() + jwtProperties.accessTokenExpiration)
    private fun getRefreshTokenExpiration(): Date =
        Date(System.currentTimeMillis() + jwtProperties.refreshTokenExpiration)
}