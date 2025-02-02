package com.example.SecurityKotlin.configurations

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "jwt")
data class JwtProperties(
    var secret: String = "", // Use var and provide default values
    var accessTokenExpiration: Long = 0, // Use var and provide default values
    var refreshTokenExpiration: Long = 0 // Use var and provide default values
)