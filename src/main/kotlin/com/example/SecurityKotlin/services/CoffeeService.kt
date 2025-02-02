package com.example.SecurityKotlin.services

import com.example.SecurityKotlin.Dtos.CoffeeDto
import com.example.SecurityKotlin.Dtos.CoffeeDtoImpl
import com.example.SecurityKotlin.entities.Coffee
import com.example.SecurityKotlin.repositories.CoffeeRepository
import com.example.SecurityKotlin.requests.CoffeeRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CoffeeService (@Autowired private val coffeeRepository:CoffeeRepository){

    fun  getCoffees():List<CoffeeDto>{
        return coffeeRepository.findAll().stream().map(this::convertEntityToDto ).toList();
    }
    fun createCoffee(coffeeRequest:CoffeeRequest):CoffeeDto{
        val newCoffee = Coffee(0,coffeeRequest.name,coffeeRequest.description,coffeeRequest.imageUrl)
        coffeeRepository.save(newCoffee)
        return convertEntityToDto(newCoffee)
    }
    fun convertEntityToDto(coffee:Coffee):CoffeeDto{
        var newDto : CoffeeDtoImpl = CoffeeDtoImpl(coffee.name,coffee.description,coffee.imageUrl)
        return newDto

    }
}