package com.example.coffee.configurations

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class CorsConfiguration {

        @Bean
        fun corsConfigurer(): WebMvcConfigurer {
            println("hello from cors configuerer")
            return object : WebMvcConfigurer {
                override fun addCorsMappings(registry: CorsRegistry) {
                    registry.addMapping("/api/**")// Apply to all endpoints under /api/
                        .allowedOrigins("http://localhost:5173") // Multiple allowed origins
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Specify allowed methods
                        .allowedHeaders("*")
                        .exposedHeaders("Content-Type","X-CSRF-Token", "Authorization","Access-Control-Allow-Origin")// Specific allowed headers
                        .allowCredentials(true)
                        .maxAge(3600)
                }
            }
        }
    }