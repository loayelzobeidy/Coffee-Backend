package com.example.SecurityKotlin.repositories

import com.example.SecurityKotlin.entities.Coffee
import org.springframework.data.jpa.repository.JpaRepository

interface CoffeeRepository : JpaRepository<Coffee, Long> {

    fun findByDescription(description: String): Coffee?
}

