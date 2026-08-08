package com.debrajghosh.nextxi.factory

import com.debrajghosh.nextxi.entity.Coach
import java.time.LocalDate
import java.time.LocalDateTime

object CoachFactory {

    fun guardiola() = Coach(
        id = 1L,
        currentTeamId = 1L,
        currentTeam = null,
        firstName = "Pep",
        lastName = "Guardiola",
        fullName = "Pep Guardiola",
        age = 52,
        birthDate = LocalDate.of(1971, 1, 18),
        birthPlace = "Santpedor",
        birthCountry = "Spain",
        nationality = "Spain",
        height = "180",
        weight = "75",
        photo = "https://example.com/pep.png",
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )

    fun mourinho() = Coach(
        id = 2L,
        currentTeamId = null,
        currentTeam = null,
        firstName = "Jose",
        lastName = "Mourinho",
        fullName = "Jose Mourinho",
        age = 58,
        birthDate = LocalDate.of(1963, 1, 26),
        birthPlace = "Setubal",
        birthCountry = "Portugal",
        nationality = "Portugal",
        height = "175",
        weight = "72",
        photo = "https://example.com/jose.png",
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )

    fun custom(
        id: Long = 1L,
        currentTeamId: Long? = null,
        firstName: String? = "Test",
        lastName: String? = "Coach",
        fullName: String = "Test Coach",
        age: Short? = 40,
        nationality: String? = "Testland"
    ) = Coach(
        id = id,
        currentTeamId = currentTeamId,
        currentTeam = null,
        firstName = firstName,
        lastName = lastName,
        fullName = fullName,
        age = age,
        birthDate = null,
        birthPlace = null,
        birthCountry = null,
        nationality = nationality,
        height = null,
        weight = null,
        photo = null,
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )
}
