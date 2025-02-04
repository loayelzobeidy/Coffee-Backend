package com.example.SecurityKotlin.entities

import java.time.LocalTime


data class OpeningHours(
    val dayOfWeek: String, // e.g., "Monday", "Tuesday"
    val openTime: LocalTime?,  // Use LocalTime for time
    val closeTime: LocalTime?
)