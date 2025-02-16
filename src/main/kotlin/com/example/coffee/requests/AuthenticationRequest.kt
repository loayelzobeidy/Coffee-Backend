package com.example.coffee.requests

data class AuthenticationRequest(
    val email: String,
    val password: String,
)