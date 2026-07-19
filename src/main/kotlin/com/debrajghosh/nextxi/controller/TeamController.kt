package com.debrajghosh.nextxi.controller

import com.debrajghosh.nextxi.dto.TeamDTO
import com.debrajghosh.nextxi.entity.Team
import com.debrajghosh.nextxi.service.TeamService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/teams")
class TeamController(
    private val teamService: TeamService
) {

    @GetMapping
    fun getAllTeams(): List<TeamDTO> {
        return teamService.getAllTeams()
    }

    @GetMapping("/{id}")
    fun getTeamById(@PathVariable id: Long): ResponseEntity<TeamDTO> {
        return teamService.getTeamById(id)
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }

    @GetMapping("/name/{name}")
    fun getTeamByName(@PathVariable name: String): ResponseEntity<TeamDTO> {
        return teamService.getTeamByName(name)
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }

    @GetMapping("/code/{code}")
    fun getTeamByCode(@PathVariable code: String): ResponseEntity<TeamDTO> {
        return teamService.getTeamByCode(code)
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }

    @GetMapping("/country")
    fun getTeamsByCountry(@RequestParam country: String): List<TeamDTO> {
        return teamService.getTeamsByCountry(country)
    }

    @GetMapping("/national")
    fun getTeamsByNational(@RequestParam national: Boolean): List<TeamDTO> {
        return teamService.getTeamsByNational(national)
    }

    @GetMapping("/venue/{venueId}")
    fun getTeamsByVenue(@PathVariable venueId: Long): List<TeamDTO> {
        return teamService.getTeamsByVenue(venueId)
    }
}
