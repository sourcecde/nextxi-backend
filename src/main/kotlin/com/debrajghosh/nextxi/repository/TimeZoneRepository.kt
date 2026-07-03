package com.debrajghosh.nextxi.repository

import com.debrajghosh.nextxi.entity.TimeZone
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TimeZoneRepository : JpaRepository<TimeZone, Long>{
    fun findByTimeZoneName(timezoneName: String)
}