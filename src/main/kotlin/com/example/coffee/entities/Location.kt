package com.example.coffee.entities

data class Location(
    val type: String = "Point", // GeoJSON Point type
    val coordinates: List<Double> // [longitude, latitude]
)