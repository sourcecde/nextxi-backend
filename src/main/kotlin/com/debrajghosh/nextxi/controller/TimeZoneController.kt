package com.debrajghosh.nextxi.controller

import com.debrajghosh.nextxi.dto.TimeZoneDTO
import com.debrajghosh.nextxi.service.TimeZoneService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/timezones")
class TimeZoneController (private val timeZoneService: TimeZoneService) {

    @GetMapping
    fun getAllTimeZones(): List<TimeZoneDTO> {
        return timeZoneService.getAllTimeZones()
    }

    @GetMapping("/id/{id}")
    fun getTimeZoneById(@PathVariable id: Long): TimeZoneDTO? {
        return timeZoneService.getTimeZoneById(id)
    }

    @GetMapping("/timezoneName")
    fun getTimeZoneByName(
        @RequestParam name: String
    ): TimeZoneDTO? {
        return timeZoneService.getTimeZoneByName(name)
    }

}