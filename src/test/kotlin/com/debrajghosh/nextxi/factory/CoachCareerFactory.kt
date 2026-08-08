package com.debrajghosh.nextxi.factory

import com.debrajghosh.nextxi.entity.CoachCareer
import java.time.LocalDate
import java.time.LocalDateTime

object CoachCareerFactory {

    fun career1() = CoachCareer(
        id = 1L,
        coachId = 1L,
        teamId = 1L,
        coach = null,
        team = null,
        startDate = LocalDate.of(2016, 7, 1),
        endDate = null,
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )

    fun career2() = CoachCareer(
        id = 2L,
        coachId = 2L,
        teamId = 3L,
        coach = null,
        team = null,
        startDate = LocalDate.of(2010, 1, 1),
        endDate = LocalDate.of(2015, 12, 31),
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )

    fun custom(id: Long = 1L, coachId: Long = 1L, teamId: Long = 1L) = CoachCareer(
        id = id,
        coachId = coachId,
        teamId = teamId,
        coach = null,
        team = null,
        startDate = LocalDate.now(),
        endDate = null,
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )
}
