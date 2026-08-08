package com.debrajghosh.nextxi.controller

import com.debrajghosh.nextxi.dto.TeamDTO
import com.debrajghosh.nextxi.service.TeamService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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
    fun getTeamById(@PathVariable id: Long): TeamDTO {
        return teamService.getTeamById(id)
    }

    @GetMapping("/name/{name}")
    fun getTeamByName(@PathVariable name: String): TeamDTO {
        return teamService.getTeamByName(name)
    }

    @GetMapping("/code/{code}")
    fun getTeamByCode(@PathVariable code: String): TeamDTO {
        return teamService.getTeamByCode(code)
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

    @GetMapping("/team-id/{teamId}")
    fun getTeamsByTeamId(@PathVariable teamId: Long): List<TeamDTO> {
        return teamService.getTeamsByTeamId(teamId)
    }
}
