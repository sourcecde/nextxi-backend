package com.debrajghosh.nextxi.service

import com.debrajghosh.nextxi.dto.CoachCareerDTO
import com.debrajghosh.nextxi.exception.ResourceNotFoundException
import com.debrajghosh.nextxi.repository.CoachCareerRepository
import org.springframework.stereotype.Service

@Service
class CoachCareerService(private val repository: CoachCareerRepository) {

    fun getAllCareers(): List<CoachCareerDTO> {
        return repository.findAll().map(CoachCareerDTO::fromObject)
    }

    fun getCareerById(id: Long): CoachCareerDTO {
        return repository.findById(id)
            .orElseThrow {
                ResourceNotFoundException("Coach career not found with id: $id")
            }
            .let(CoachCareerDTO::fromObject)
    }

    fun getCareersByCoach(coachId: Long): List<CoachCareerDTO> {
        return repository.findByCoachId(coachId).map(CoachCareerDTO::fromObject)
    }

    fun getCareersByTeam(teamId: Long): List<CoachCareerDTO> {
        return repository.findByTeamId(teamId).map(CoachCareerDTO::fromObject)
    }
}
