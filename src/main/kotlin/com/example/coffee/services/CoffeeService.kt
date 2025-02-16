package com.example.coffee.services

import com.example.coffee.dtos.CoffeeDto
import com.example.coffee.dtos.CoffeeDtoImpl
import com.example.coffee.entities.Coffee
import com.example.coffee.repositories.CoffeeRepository
import com.example.coffee.requests.CoffeeRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CoffeeService (@Autowired private val coffeeRepository:CoffeeRepository){

    fun  getCoffees():List<CoffeeDto>{
        return coffeeRepository.findAll().stream().map(this::convertEntityToDto ).toList();
    }
    fun createCoffee(coffeeRequest:CoffeeRequest):CoffeeDto{
        val newCoffee = Coffee(0,coffeeRequest.name,coffeeRequest.price,coffeeRequest.description,coffeeRequest.imageUrl)
        coffeeRepository.save(newCoffee)
        return convertEntityToDto(newCoffee)
    }
    fun convertEntityToDto(coffee:Coffee):CoffeeDto{
        var newDto : CoffeeDtoImpl = CoffeeDtoImpl(coffee.name,coffee.description,coffee.imageUrl)
        return newDto

    }
}