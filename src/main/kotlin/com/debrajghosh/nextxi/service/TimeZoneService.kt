package com.debrajghosh.nextxi.service

import com.debrajghosh.nextxi.dto.TimeZoneDTO
import com.debrajghosh.nextxi.repository.TimeZoneRepository
import org.springframework.stereotype.Service

/**
 * Provide read only operation for timezone master data
 */
@Service
class TimeZoneService(
    private val timeZoneRepository: TimeZoneRepository
) {

    /**
     * Retrieve all timezone
     *
     * @return list of all countries
     */
    fun getAllTimeZones(): List<TimeZoneDTO> {
        return timeZoneRepository.findAll().map(TimeZoneDTO::fromObject)
    }

    /**
     * retrieve timezone by id
     * @param id
     * @return timezone
     */

    fun getTimeZoneById(id: Long): TimeZoneDTO? {
        return timeZoneRepository.findById(id)
            .orElse(null)
            ?.let(TimeZoneDTO::fromObject)
    }
}