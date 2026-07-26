package com.debrajghosh.nextxi.factory

import com.debrajghosh.nextxi.entity.Venue
import java.time.LocalDateTime

object VenueFactory {

    fun allianzArena() = Venue(
        id = 1L,
        venueId = 6,
        name = "Allianz Arena",
        address = "Werner-Heisenberg-Allee 25",
        city = "Munich",
        country = "Germany",
        capacity = 75000,
        surface = "Grass",
        image = "https://media.api-sports.io/venues/1.png",
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )

    fun olympiastadion() = Venue(
        id = 2L,
        venueId = 10,
        name = "Olympiastadion",
        address = "Olympischer Platz 3",
        city = "Berlin",
        country = "Germany",
        capacity = 74475,
        surface = "Grass",
        image = "https://media.api-sports.io/venues/10.png",
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )

    fun stamfordBridge() = Venue(
        id = 3L,
        venueId = 15,
        name = "Stamford Bridge",
        address = "Fulham Road",
        city = "London",
        country = "England",
        capacity = 63261,
        surface = "Grass",
        image = "https://media.api-sports.io/venues/15.png",
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )

    fun custom(
        id: Long = 1L,
        venueId: Int = 1,
        name: String = "Test Venue",
        address: String? = "123 Test Street",
        city: String? = "Test City",
        country: String? = "Test Country",
        capacity: Int? = 50000,
        surface: String? = "Grass",
        image: String? = "https://test.png"
    ) = Venue(
        id = id,
        venueId = venueId,
        name = name,
        address = address,
        city = city,
        country = country,
        capacity = capacity,
        surface = surface,
        image = image,
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )
}
