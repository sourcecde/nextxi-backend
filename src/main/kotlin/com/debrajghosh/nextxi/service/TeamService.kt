package com.debrajghosh.nextxi.service

import com.debrajghosh.nextxi.dto.TeamDTO
import com.debrajghosh.nextxi.exception.ResourceNotFoundException
import com.debrajghosh.nextxi.repository.TeamRepository
import org.springframework.stereotype.Service

/**
 * Provides CRUD operations for team data.
 */
@Service
class TeamService(private val repository: TeamRepository) {

    /**
     * Retrieves all teams.
     *
     * @return List of all teams.
     */
    fun getAllTeams(): List<TeamDTO> {
        return repository.findAll().map(TeamDTO::fromObject)
    }

    /**
     * Retrieves a team by database ID.
     *
     * @param id Database ID.
     * @return TeamDTO.
     */
    fun getTeamById(id: Long): TeamDTO {
        return repository.findById(id)
            .orElseThrow {
                ResourceNotFoundException("Team not found with id: $id")
            }
            .let(TeamDTO::fromObject)
    }

    /**
     * Retrieves a team by name.
     *
     * @param name Team name.
     * @return TeamDTO.
     */
    fun getTeamByName(name: String): TeamDTO {
        return repository.findByName(name)
            .orElseThrow {
                ResourceNotFoundException("Team not found with name: $name")
            }
            .let(TeamDTO::fromObject)
    }

    /**
     * Retrieves a team by code.
     *
     * @param code Team code.
     * @return TeamDTO.
     */
    fun getTeamByCode(code: String): TeamDTO {
        return repository.findByCode(code)
            .orElseThrow {
                ResourceNotFoundException("Team not found with code: $code")
            }
            .let(TeamDTO::fromObject)
    }

    /**
     * Retrieves all teams by country.
     *
     * @param country Country name.
     * @return List of teams from specified country.
     */
    fun getTeamsByCountry(country: String): List<TeamDTO> {
        return repository.findByCountry(country).map(TeamDTO::fromObject)
    }

    /**
     * Retrieves all teams by national status.
     *
     * @param national Whether to fetch national teams or not.
     * @return List of teams with specified national status.
     */
    fun getTeamsByNational(national: Boolean): List<TeamDTO> {
        return repository.findByNational(national).map(TeamDTO::fromObject)
    }

    /**
     * Retrieves all teams by venue ID.
     *
     * @param venueId Venue ID.
     * @return List of teams associated with the venue.
     */
    fun getTeamsByVenue(venueId: Long): List<TeamDTO> {
        return repository.findByVenueId(venueId).map(TeamDTO::fromObject)
    }

    /**
     * Retrieves all teams by external team ID.
     *
     * @param teamId External team ID.
     * @return List of teams associated with the external team ID.
     */
    fun getTeamsByTeamId(teamId: Long): List<TeamDTO> {
        return repository.findByTeamId(teamId).map(TeamDTO::fromObject)
    }
}
