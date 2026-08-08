package com.debrajghosh.nextxi.dto

import com.debrajghosh.nextxi.entity.Team

data class TeamDTO(
    val id: Long,
    val venueId: Long?,
    val name: String,
    val code: String?,
    val country: String?,
    val founded: Short?,
    val national: Boolean,
    val logo: String?
) {
    companion object {
        fun fromObject(team: Team): TeamDTO {
            return TeamDTO(
                id = team.id,
                venueId = team.venueId,
                name = team.name,
                code = team.code,
                country = team.country,
                founded = team.founded,
                national = team.national,
                logo = team.logo
            )
        }
    }
}
