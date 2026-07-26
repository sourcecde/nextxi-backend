package com.debrajghosh.nextxi.service

import com.debrajghosh.nextxi.dto.VenueDTO
import com.debrajghosh.nextxi.exception.ResourceNotFoundException
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
     * @return VenueDTO.
     */
    fun getVenueById(id: Long): VenueDTO {
        return repository.findById(id)
            .orElseThrow {
                ResourceNotFoundException("Venue not found with id: $id")
            }
            .let(VenueDTO::fromObject)
    }

    /**
     * Retrieve a venue by venue ID (external API id stored as venue_id).
     *
     * @param venueId External API venue ID.
     * @return VenueDTO.
     */
    fun getVenueByVenueId(venueId: Int): VenueDTO {
        return repository.findByVenueId(venueId)
            .orElseThrow {
                ResourceNotFoundException("Venue not found with venueId: $venueId")
            }
            .let(VenueDTO::fromObject)
    }

    /**
     * Retrieve a venue by name.
     *
     * @param venueName Venue name.
     * @return VenueDTO.
     */
    fun getVenueByName(venueName: String): VenueDTO {
        return repository.findByName(venueName)
            .orElseThrow {
                ResourceNotFoundException("Venue not found with name: $venueName")
            }
            .let(VenueDTO::fromObject)
    }
}