package com.example.SecurityKotlin.Dtos

data class CoffeeDtoImpl(
    override var name: String,
    override var description: String,
    override var imageUrl: String
) : CoffeeDto