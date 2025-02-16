package com.example.coffee.controllers

import com.example.coffee.entities.Order
import com.example.coffee.services.OrderService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/orders")
class OrderController(private val orderService: OrderService){

    @GetMapping("/")
    fun getAllOrders():List<Order>{
        return orderService.allOrders;
    }

}