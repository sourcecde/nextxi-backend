package com.debrajghosh.nextxi.controller

import com.debrajghosh.nextxi.dto.VenueDTO
import com.debrajghosh.nextxi.service.VenueService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/venues")
class VenueController(
    private val venueService: VenueService
) {

    @GetMapping
    fun getAllVenues(): List<VenueDTO> {
        return venueService.getAllVenues()
    }

    @GetMapping("/{id}")
    fun getVenueById(@PathVariable id: Long): VenueDTO? {
        return venueService.getVenueById(id)
    }

    @GetMapping("/api-id/{apiId}")
    fun getVenueByApiId(@PathVariable apiId: Int): VenueDTO? {
        return venueService.getVenueByApiId(apiId)
    }

    @GetMapping("/name/{name}")
    fun getVenueByName(@PathVariable name: String): VenueDTO? {
        return venueService.getVenueByName(name)
    }
}