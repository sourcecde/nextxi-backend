package com.debrajghosh.nextxi.controller

import com.debrajghosh.nextxi.dto.CoachCareerDTO
import com.debrajghosh.nextxi.service.CoachCareerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/coach-careers")
class CoachCareerController(private val service: CoachCareerService) {

    @GetMapping
    fun getAllCareers(): List<CoachCareerDTO> = service.getAllCareers()

    @GetMapping("/{id}")
    fun getCareerById(@PathVariable id: Long): ResponseEntity<CoachCareerDTO> {
        return service.getCareerById(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @GetMapping("/coach/{coachId}")
    fun getCareersByCoach(@PathVariable coachId: Long): List<CoachCareerDTO> = service.getCareersByCoach(coachId)

    @GetMapping("/team/{teamId}")
    fun getCareersByTeam(@PathVariable teamId: Long): List<CoachCareerDTO> = service.getCareersByTeam(teamId)
}
