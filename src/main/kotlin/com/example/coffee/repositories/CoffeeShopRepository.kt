package com.example.coffee.repositories

import com.example.coffee.entities.CoffeeShop
import org.springframework.data.mongodb.repository.MongoRepository

interface CoffeeShopRepository : MongoRepository<CoffeeShop, String> {
    fun findByName(name: String): List<CoffeeShop>
}