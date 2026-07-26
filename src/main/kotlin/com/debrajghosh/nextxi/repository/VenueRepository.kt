package com.debrajghosh.nextxi.repository

import com.debrajghosh.nextxi.entity.Venue
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface VenueRepository : JpaRepository<Venue, Long> {
    fun findByVenueId(venueId: Int): Optional<Venue>
    fun findByName(name: String): Optional<Venue>
}