package com.example.coffee.requests

import com.example.coffee.entities.Role
import com.example.coffee.entities.User

data class UserRequest(
    val email: String,
    val password: String,
    val name:String,
    val role: Role
) {
    fun toModel(): User =
        User(
            id = 0,
            email = this.email,
            name = this.name,
            password = this.password,
            role = this.role
        )
}