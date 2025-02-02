package com.example.SecurityKotlin.requests

data class AuthenticationRequest(
    val email: String,
    val password: String,
)