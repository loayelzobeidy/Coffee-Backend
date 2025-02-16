package com.example.coffee.requests

import com.example.coffee.entities.*
import java.time.LocalTime

data class CreateCoffeeShopRequest(
val name: String,
val street: String,
val city: String,
val postalCode: String,
val country: String,
val longitude: Double, // Separate longitude and latitude
val latitude: Double,
val phoneNumber: String?,
val website: String?,
val openingHours: List<CreateOpeningHoursRequest>,
val coffeeTypes: List<String>,
val hasWifi: Boolean,
val hasOutdoorSeating: Boolean,
val hasParking: Boolean,
val servesFood: Boolean
// Reviews are usually not part of the initial creation request
)

data class CreateOpeningHoursRequest(
    val dayOfWeek: String,
    val openTime: String?, // Use String for input, convert to LocalTime later
    val closeTime: String?
)


// Conversion function (in your service or a utility class)
fun CreateCoffeeShopRequest.toCoffeeShop(): CoffeeShop {
    val address = Address(street, city, postalCode, country)
    val location = Location(coordinates = listOf(longitude, latitude))  // Correct order: longitude, latitude
    val openingHoursList = openingHours.map { it.toOpeningHours() }
    val amenities = Amenities(hasWifi, hasOutdoorSeating, hasParking, servesFood)

    return CoffeeShop(
        name = name,
        address = address,
        location = location,
        phoneNumber = phoneNumber,
        website = website,
        openingHours = openingHoursList,
        coffeeTypes = coffeeTypes,
        amenities = amenities
        // Reviews are usually added later
    )
}

fun CreateOpeningHoursRequest.toOpeningHours(): OpeningHours {
    val openTimeLocalTime = openTime?.let { LocalTime.parse(it) } // Handle null and parse
    val closeTimeLocalTime = closeTime?.let { LocalTime.parse(it) }
    return OpeningHours(dayOfWeek, openTimeLocalTime, closeTimeLocalTime)
}
