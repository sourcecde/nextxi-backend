package com.debrajghosh.nextxi.repository

import com.debrajghosh.nextxi.entity.Venue
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VenueRepository : JpaRepository<Venue, Long> {
    fun findByApiId(apiId: Int): Venue?
    fun findByName(name: String): Venue?
}