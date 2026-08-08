package com.debrajghosh.nextxi.repository

import com.debrajghosh.nextxi.entity.Team
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface TeamRepository : JpaRepository<Team, Long> {
    fun findByName(name: String): Optional<Team>
    fun findByCode(code: String): Optional<Team>
    fun findByCountry(country: String): List<Team>
    fun findByNational(national: Boolean): List<Team>
    fun findByVenueId(venueId: Long): List<Team>
    fun findByTeamId(teamId: Long): List<Team>
}
