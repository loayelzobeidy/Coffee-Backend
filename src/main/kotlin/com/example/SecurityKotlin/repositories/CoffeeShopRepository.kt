package com.example.SecurityKotlin.repositories

import com.example.SecurityKotlin.entities.CoffeeShop
import org.springframework.data.mongodb.repository.MongoRepository

interface CoffeeShopRepository : MongoRepository<CoffeeShop, String> {
    fun findByName(name: String): List<CoffeeShop>
}