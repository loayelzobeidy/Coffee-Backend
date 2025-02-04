package com.example.SecurityKotlin.entities


data class Amenities(
    val hasWifi: Boolean,
    val hasOutdoorSeating: Boolean,
    val hasParking: Boolean,
    val servesFood: Boolean // Add other relevant amenities
)
