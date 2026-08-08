package com.debrajghosh.nextxi.repository

import com.debrajghosh.nextxi.entity.CoachCareer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CoachCareerRepository : JpaRepository<CoachCareer, Long> {
    fun findByCoachId(coachId: Long): List<CoachCareer>
    fun findByTeamId(teamId: Long): List<CoachCareer>
}
