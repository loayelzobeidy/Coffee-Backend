package com.example.SecurityKotlin.services

import com.example.SecurityKotlin.entities.CoffeeShop
import com.example.SecurityKotlin.repositories.CoffeeShopRepository
import org.springframework.stereotype.Service

@Service
class CoffeeShopService(private val coffeeShopRepository: CoffeeShopRepository) {
    fun getAllCoffeeShops(): List<CoffeeShop> = coffeeShopRepository.findAll()
    fun createCoffeeShop(coffeeShop: CoffeeShop): CoffeeShop {
        return coffeeShopRepository.save(coffeeShop)
    }
}