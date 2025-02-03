package com.example.SecurityKotlin.controllers

import com.example.SecurityKotlin.entities.CoffeeShop
import com.example.SecurityKotlin.requests.CreateCoffeeShopRequest
import com.example.SecurityKotlin.requests.toCoffeeShop
import com.example.SecurityKotlin.services.CoffeeShopService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/api/v1/coffeeshops")
class CoffeeShopController (val coffeeShopService: CoffeeShopService){
    @GetMapping("/")
    fun getShops():List<CoffeeShop>{
        return coffeeShopService.getAllCoffeeShops();
    }
    @PostMapping("/")
    fun createShop(@RequestBody request: CreateCoffeeShopRequest): ResponseEntity<CoffeeShop> {
        val coffeeShop = request.toCoffeeShop() // Convert the request to a CoffeeShop entity
        val createdCoffeeShop = coffeeShopService.createCoffeeShop(coffeeShop)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCoffeeShop)
    }
}