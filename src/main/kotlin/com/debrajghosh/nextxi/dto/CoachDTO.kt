package com.debrajghosh.nextxi.dto

import com.debrajghosh.nextxi.entity.Coach
import java.time.LocalDate

data class CoachDTO(
    val id: Long,
    val currentTeamId: Long?,
    val firstName: String?,
    val lastName: String?,
    val fullName: String,
    val age: Short?,
    val birthDate: LocalDate?,
    val birthPlace: String?,
    val birthCountry: String?,
    val nationality: String?,
    val height: String?,
    val weight: String?,
    val photo: String?
) {
    companion object {
        fun fromObject(coach: Coach): CoachDTO {
            return CoachDTO(
                id = coach.id,
                currentTeamId = coach.currentTeamId,
                firstName = coach.firstName,
                lastName = coach.lastName,
                fullName = coach.fullName,
                age = coach.age,
                birthDate = coach.birthDate,
                birthPlace = coach.birthPlace,
                birthCountry = coach.birthCountry,
                nationality = coach.nationality,
                height = coach.height,
                weight = coach.weight,
                photo = coach.photo
            )
        }
    }
}
