package com.example.coffee.entities

data class Review(
    val userId: String, // Or a User object if you have a User entity
    val rating: Int, // 1-5 star rating
    val comment: String?
)