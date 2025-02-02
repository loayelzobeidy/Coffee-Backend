package com.example.SecurityKotlin.controllers

import com.example.SecurityKotlin.Dtos.CoffeeDto
import com.example.SecurityKotlin.requests.CoffeeRequest
import com.example.SecurityKotlin.services.CoffeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/coffees")
class CoffeeController(@Autowired private val coffeeService: CoffeeService) {

    @GetMapping("/")
    fun  getCoffees():List<CoffeeDto>{
        return coffeeService.getCoffees();
    }


    @PostMapping("/")
    fun createCoffee(@Validated @RequestBody coffeeRequest: CoffeeRequest): ResponseEntity<CoffeeDto> {
        println("$coffeeRequest coffee requesst")
        val coffee = coffeeService.createCoffee(coffeeRequest)
        return ResponseEntity.status(HttpStatus.CREATED).body(coffee)
    }
}
