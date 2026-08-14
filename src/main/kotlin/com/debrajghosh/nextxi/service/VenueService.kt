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
     * Retrieve a venue by Venue ID.
     *
     * @param venueId External API venue ID.
     * @return VenueDTO or null if not found.
     */
    fun getVenueByVenueId(venueId: Int): VenueDTO? {
        return repository.findByVenueId(venueId)
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