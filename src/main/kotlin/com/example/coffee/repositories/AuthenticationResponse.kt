package com.example.coffee.repositories

import com.example.coffee.entities.Role

data class AuthenticationResponse(
    val role:Role?,
    val name: String?,
    val email:String?,
    val accessToken: String,
    val refreshToken: String,
)