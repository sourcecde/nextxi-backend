package com.debrajghosh.nextxi.controller

import com.debrajghosh.nextxi.dto.CoachDTO
import com.debrajghosh.nextxi.service.CoachService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/coaches")
class CoachController(private val coachService: CoachService) {

    @GetMapping
    fun getAllCoaches(): List<CoachDTO> = coachService.getAllCoaches()

    @GetMapping("/{id}")
    fun getCoachById(@PathVariable id: Long): ResponseEntity<CoachDTO> {
        return coachService.getCoachById(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @GetMapping("/name/{fullName}")
    fun getCoachByFullName(@PathVariable fullName: String): ResponseEntity<CoachDTO> {
        return coachService.getCoachByFullName(fullName)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @GetMapping("/nationality")
    fun getCoachesByNationality(@RequestParam nationality: String): List<CoachDTO> = coachService.getCoachesByNationality(nationality)

    @GetMapping("/team/{teamId}")
    fun getCoachesByCurrentTeam(@PathVariable teamId: Long): List<CoachDTO> = coachService.getCoachesByCurrentTeam(teamId)
}
