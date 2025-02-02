package com.example.SecurityKotlin.repositories

data class AuthenticationResponse(
    val accessToken: String,
    val refreshToken: String,
)