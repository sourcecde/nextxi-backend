package com.debrajghosh.nextxi.factory

import com.debrajghosh.nextxi.entity.Team
import java.time.LocalDateTime

object TeamFactory {

    fun bayern() = Team(
        id = 1L,
        venueId = 1L,
        name = "Bayern Munich",
        code = "BAY",
        country = "Germany",
        founded = 1900,
        national = false,
        logo = "https://media.api-sports.io/teams/1.png",
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )

    fun manchester() = Team(
        id = 2L,
        venueId = 3L,
        name = "Manchester United",
        code = "MNU",
        country = "England",
        founded = 1878,
        national = false,
        logo = "https://media.api-sports.io/teams/2.png",
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )

    fun parisStGermain() = Team(
        id = 3L,
        venueId = null,
        name = "Paris Saint-Germain",
        code = "PSG",
        country = "France",
        founded = 1970,
        national = false,
        logo = "https://media.api-sports.io/teams/3.png",
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )

    fun germany() = Team(
        id = 4L,
        venueId = null,
        name = "Germany",
        code = "GER",
        country = "Germany",
        founded = 1908,
        national = true,
        logo = "https://media.api-sports.io/teams/4.png",
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )

    fun france() = Team(
        id = 5L,
        venueId = null,
        name = "France",
        code = "FRA",
        country = "France",
        founded = 1904,
        national = true,
        logo = "https://media.api-sports.io/teams/5.png",
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )

    fun custom(
        id: Long = 1L,
        venueId: Long? = null,
        name: String = "Test Team",
        code: String? = "TST",
        country: String? = "Test Country",
        founded: Short? = 2000,
        national: Boolean = false,
        logo: String? = "https://test.png"
    ) = Team(
        id = id,
        venueId = venueId,
        name = name,
        code = code,
        country = country,
        founded = founded,
        national = national,
        logo = logo,
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )
}
