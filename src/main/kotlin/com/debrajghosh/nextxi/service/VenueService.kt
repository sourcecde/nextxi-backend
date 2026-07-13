package com.debrajghosh.nextxi.service

import com.debrajghosh.nextxi.dto.VenueDTO
import com.debrajghosh.nextxi.repository.VenueRepository
import org.springframework.stereotype.Service

/**
 * Provides read-only operations for venue master data.
 */
@Service
class VenueService(private val repository: VenueRepository) {

    /**
     * Retrieves all available venues.
     *
     * @return List of venues.
     */
    fun getAllVenues(): List<VenueDTO> {
        return repository.findAll().map(VenueDTO::fromObject)
    }

    /**
     * Retrieve a venue by database ID.
     *
     * @param id Database ID.
     * @return VenueDTO or null if not found.
     */
    fun getVenueById(id: Long): VenueDTO? {
        return repository.findById(id)
            .orElse(null)
            ?.let(VenueDTO::fromObject)
    }

    /**
     * Retrieve a venue by API ID.
     *
     * @param apiId External API venue ID.
     * @return VenueDTO or null if not found.
     */
    fun getVenueByApiId(apiId: Int): VenueDTO? {
        return repository.findByApiId(apiId)
            ?.let(VenueDTO::fromObject)
    }

    /**
     * Retrieve a venue by name.
     *
     * @param venueName Venue name.
     * @return VenueDTO or null if not found.
     */
    fun getVenueByName(venueName: String): VenueDTO? {
        return repository.findByName(venueName)
            ?.let(VenueDTO::fromObject)
    }
}