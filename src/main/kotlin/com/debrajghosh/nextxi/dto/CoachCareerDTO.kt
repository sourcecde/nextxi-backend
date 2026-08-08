package com.debrajghosh.nextxi.dto

import com.debrajghosh.nextxi.entity.CoachCareer
import java.time.LocalDate

data class CoachCareerDTO(
    val id: Long?,
    val coachId: Long,
    val teamId: Long,
    val startDate: LocalDate,
    val endDate: LocalDate?
) {
    companion object {
        fun fromObject(career: CoachCareer): CoachCareerDTO {
            return CoachCareerDTO(
                id = career.id,
                coachId = career.coachId,
                teamId = career.teamId,
                startDate = career.startDate,
                endDate = career.endDate
            )
        }
    }
}
