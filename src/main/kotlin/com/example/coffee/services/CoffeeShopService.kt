package com.example.coffee.services

import com.example.coffee.entities.CoffeeShop
import com.example.coffee.repositories.CoffeeShopRepository
import org.springframework.stereotype.Service

@Service
class CoffeeShopService(private val coffeeShopRepository: CoffeeShopRepository) {
    fun getAllCoffeeShops(): List<CoffeeShop> = coffeeShopRepository.findAll()
    fun createCoffeeShop(coffeeShop: CoffeeShop): CoffeeShop {
        return coffeeShopRepository.save(coffeeShop)
    }
}