package com.example.coffee.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("coffee_shops") // Collection name in MongoDB
data class CoffeeShop(
    @Id val id: String? = null, // Optional ID, MongoDB will generate one if null
    val name: String,
    val address: Address,
    val location: Location, // GeoJSON location for geospatial queries
    val phoneNumber: String?,
    val website: String?,
    val openingHours: List<OpeningHours>,
    val coffeeTypes: List<String>, // List of coffee types offered
    val amenities: Amenities,
    val reviews: List<Review> = emptyList() // Initialize as empty list
)





