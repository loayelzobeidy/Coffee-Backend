package com.example.SecurityKotlin.requests

import com.example.SecurityKotlin.entities.Role
import com.example.SecurityKotlin.entities.User

data class UserRequest(
    val email: String,
    val password: String,
    val role: Role
) {
    fun toModel(): User =
        User(
            id = 0,
            email = this.email,
            password = this.password,
            role = this.role
        )
}