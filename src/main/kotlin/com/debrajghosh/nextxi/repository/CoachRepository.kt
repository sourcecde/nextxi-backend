package com.debrajghosh.nextxi.repository

import com.debrajghosh.nextxi.entity.Coach
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface CoachRepository : JpaRepository<Coach, Long> {
    fun findByFullName(fullName: String): Optional<Coach>
    fun findByNationality(nationality: String): List<Coach>
    fun findByCurrentTeamId(teamId: Long): List<Coach>
}
