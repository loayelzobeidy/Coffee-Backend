package com.example.coffee.controllers

import com.example.coffee.repositories.AuthenticationResponse
import com.example.coffee.requests.AuthenticationRequest
import com.example.coffee.requests.RefreshTokenRequest
import com.example.coffee.responses.TokenResponse
import com.example.coffee.services.AuthenticationService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.security.web.csrf.CsrfToken
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = ["http://localhost:5173"])
class AuthController(
    private val authenticationService: AuthenticationService
) {
    @GetMapping("/register/")
    fun getCsrfToken(request: HttpServletRequest): CsrfToken {
        println("here inside registraation")
        val token: CsrfToken = request.getAttribute(CsrfToken::class.java.getName()) as CsrfToken
        return token // Return the token as a string
    }
    @PostMapping
    fun authenticate(
        @RequestBody authRequest: AuthenticationRequest
    ): AuthenticationResponse =
        authenticationService.authentication(authRequest)

    @PostMapping("/refresh")
    fun refreshAccessToken(
        @RequestBody request: RefreshTokenRequest
    ): TokenResponse =
        authenticationService.refreshAccessToken(request.token)
            ?.mapToTokenResponse()
            ?: throw ResponseStatusException(HttpStatus.FORBIDDEN, "Invalid refresh token.")

    private fun String.mapToTokenResponse(): TokenResponse =
        TokenResponse(
            token = this
        )

}