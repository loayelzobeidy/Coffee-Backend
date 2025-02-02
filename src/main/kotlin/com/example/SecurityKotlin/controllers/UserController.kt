package com.example.SecurityKotlin.controllers

import com.example.SecurityKotlin.entities.Role
import com.example.SecurityKotlin.entities.User
import com.example.SecurityKotlin.requests.UserRequest
import com.example.SecurityKotlin.responses.UserResponse
import com.example.SecurityKotlin.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime
import java.util.*

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService
) {

    @PostMapping
    fun create(@RequestBody userRequest: UserRequest): UserResponse {
        println("user request" +userRequest)
        var createdUser = userService.createUser(userRequest.toModel())
            ?.toResponse()
            ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot create user.")
        println("created user "+createdUser)
        return createdUser
    }

    @GetMapping("/")
    fun listAll(): List<UserResponse> =
        userService.findAll()
            .map { it.toResponse() }

    @GetMapping("/{uuid}")
    fun findByUUID(@PathVariable uuid: Long): UserResponse =
        userService.findByUUID(uuid)
            ?.toResponse()
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.")


    @DeleteMapping("/{uuid}")
    fun deleteByUUID(@PathVariable uuid: Long): ResponseEntity<Boolean> {
        val success = userService.deleteByUUID(uuid)

        return if (success)
            ResponseEntity.noContent()
                .build()
        else
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.")
    }

    private fun User.toResponse(): UserResponse =
        UserResponse(
            uuid = this.id,
            email = this.email,
        )

    private fun UserRequest.toModel(): User =
        User(
            id = 0,
            email = this.email,
            password = this.password,
            role = this.role
        )
}