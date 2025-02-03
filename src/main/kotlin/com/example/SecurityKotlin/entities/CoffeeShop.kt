package com.example.SecurityKotlin.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalTime

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

data class Address(
    val street: String,
    val city: String,
    val postalCode: String,
    val country: String
)

data class Location(
    val type: String = "Point", // GeoJSON Point type
    val coordinates: List<Double> // [longitude, latitude]
)

data class OpeningHours(
    val dayOfWeek: String, // e.g., "Monday", "Tuesday"
    val openTime: LocalTime?,  // Use LocalTime for time
    val closeTime: LocalTime?
)

data class Amenities(
    val hasWifi: Boolean,
    val hasOutdoorSeating: Boolean,
    val hasParking: Boolean,
    val servesFood: Boolean // Add other relevant amenities
)

data class Review(
    val userId: String, // Or a User object if you have a User entity
    val rating: Int, // 1-5 star rating
    val comment: String?
)