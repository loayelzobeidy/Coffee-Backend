package com.example.coffee.controllers

import com.example.coffee.entities.Order
import com.example.coffee.services.OrderService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/orders")
class OrderController(private val orderService: OrderService){

    @GetMapping("/")
    fun getAllOrders():List<Order>{
        return orderService.allOrders;
    }

    @PostMapping("/")
    fun CreateOrder(@Validated @RequestBody order:Order):Order{
        return orderService.createOrder(order);
    }

}