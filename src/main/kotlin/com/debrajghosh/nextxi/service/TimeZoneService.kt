package com.debrajghosh.nextxi.service

import com.debrajghosh.nextxi.dto.TimeZoneDTO
import com.debrajghosh.nextxi.repository.TimeZoneRepository
import org.springframework.stereotype.Service

@Service
class TimeZoneService(
    private val timeZoneRepository: TimeZoneRepository
) {

    fun getAllTimeZones(): List<TimeZoneDTO> {
        return timeZoneRepository.findAll().map(TimeZoneDTO::fromObject)
    }

    fun getTimeZoneById(id: Long): TimeZoneDTO? {
        return timeZoneRepository.findById(id)
            .orElse(null)
            ?.let(TimeZoneDTO::fromObject)
    }
}