package com.example.coffee.repositories

import com.example.coffee.entities.Coffee
import org.springframework.data.jpa.repository.JpaRepository

interface CoffeeRepository : JpaRepository<Coffee, Long> {

    fun findByDescription(description: String): Coffee?
}

