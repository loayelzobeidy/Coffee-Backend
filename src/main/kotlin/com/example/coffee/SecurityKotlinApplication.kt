package com.example.coffee

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition(info = Info(title = "Your API Title", version = "1.0", description = "Your API Description"))
class SecurityKotlinApplication

fun main(args: Array<String>) {
	runApplication<SecurityKotlinApplication>(*args)
}
