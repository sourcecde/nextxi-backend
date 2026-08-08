package com.debrajghosh.nextxi.service

import com.debrajghosh.nextxi.dto.CoachDTO
import com.debrajghosh.nextxi.repository.CoachRepository
import org.springframework.stereotype.Service

@Service
class CoachService(private val repository: CoachRepository) {

    fun getAllCoaches(): List<CoachDTO> {
        return repository.findAll().map(CoachDTO::fromObject)
    }

    fun getCoachById(id: Long): CoachDTO? {
        return repository.findById(id)
            .orElse(null)
            ?.let(CoachDTO::fromObject)
    }

    fun getCoachByFullName(fullName: String): CoachDTO? {
        return repository.findByFullName(fullName)?.let(CoachDTO::fromObject)
    }

    fun getCoachesByNationality(nationality: String): List<CoachDTO> {
        return repository.findByNationality(nationality).map(CoachDTO::fromObject)
    }

    fun getCoachesByCurrentTeam(teamId: Long): List<CoachDTO> {
        return repository.findByCurrentTeamId(teamId).map(CoachDTO::fromObject)
    }
}
