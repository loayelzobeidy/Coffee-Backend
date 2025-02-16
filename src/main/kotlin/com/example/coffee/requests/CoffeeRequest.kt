package com.example.coffee.requests

data class CoffeeRequest(
    val name: String,
    val description: String,
    val price:Long,
    val imageUrl: String,
)