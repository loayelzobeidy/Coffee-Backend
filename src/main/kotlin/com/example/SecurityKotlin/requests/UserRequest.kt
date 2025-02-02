package com.example.SecurityKotlin.requests

import com.example.SecurityKotlin.entities.Role

data class UserRequest(
    val email: String,
    val password: String,
    val role: Role
)