package com.example.coffee.controllers

import com.example.coffee.entities.User
import com.example.coffee.requests.UserRequest
import com.example.coffee.responses.UserResponse
import com.example.coffee.services.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/")

@Tag(name = "user", description = "Rest API for user operations")

class UserController(
    private val userService: UserService
) {

    @PostMapping("signup/")
    fun create(@RequestBody userRequest: UserRequest): UserResponse {
        println("user request" +userRequest)
        var createdUser = userService.createUser(userRequest.toModel())
            ?.toResponse()
            ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot create user.")
        println("created user "+createdUser)
        return createdUser
    }
    @Operation(summary = "Display all non admin users")
    @ApiResponses(
        value = arrayOf(
            ApiResponse(responseCode = "200", description = "OK")
        )
    )

    @GetMapping("/users/")
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


}