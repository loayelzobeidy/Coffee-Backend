package com.example.coffee.controllers

import com.example.coffee.Dtos.CoffeeDto
import com.example.coffee.requests.CoffeeRequest
import com.example.coffee.services.CoffeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/coffees")
@CrossOrigin(origins = ["http://localhost:5173"], allowedHeaders = ["Authorization","Content-t"])

class CoffeeController(@Autowired private val coffeeService: CoffeeService) {
    @Operation(summary = "Get all coffee drinks", description ="get all the coffee drinks ")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Successful operation"),
        ApiResponse(responseCode = "404", description = "User not found")
    ])
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
