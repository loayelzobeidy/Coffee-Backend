package com.example.coffee.responses

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Model for a dealer's view of a car.")

data class UserResponse(
    // Other fields
    @field:Schema(
        description = "A User UUID",
        type = "Long",
        required=true
    )
    val uuid: Long,
    @field:Schema(
        description = "A User email",
        type = "String",
        required=true
    )
    val email: String,
)