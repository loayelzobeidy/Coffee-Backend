package com.example.coffee.Dtos

data class CoffeeDtoImpl(
    override var name: String,
    override var description: String,
    override var imageUrl: String
) : CoffeeDto