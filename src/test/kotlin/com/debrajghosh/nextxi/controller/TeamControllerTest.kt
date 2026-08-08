package com.debrajghosh.nextxi.controller

import com.debrajghosh.nextxi.dto.TeamDTO
import com.debrajghosh.nextxi.service.TeamService
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyLong
import org.mockito.ArgumentMatchers.anyString
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(TeamController::class)
class TeamControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockitoBean
    lateinit var teamService: TeamService

    @Test
    fun `should return all teams`() {
        val teams = listOf(
            TeamDTO(1L, 1L, "Bayern Munich", "BAY", "Germany", 1900, false, "https://media.api-sports.io/teams/1.png"),
            TeamDTO(2L, 3L, "Manchester United", "MNU", "England", 1878, false, "https://media.api-sports.io/teams/2.png"),
            TeamDTO(3L, null, "Paris Saint-Germain", "PSG", "France", 1970, false, "https://media.api-sports.io/teams/3.png")
        )

        given(teamService.getAllTeams()).willReturn(teams)

        mockMvc.perform(get("/api/v1/teams"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$[0].name").value("Bayern Munich"))
            .andExpect(jsonPath("$[0].code").value("BAY"))
            .andExpect(jsonPath("$[0].country").value("Germany"))
            .andExpect(jsonPath("$[1].name").value("Manchester United"))
            .andExpect(jsonPath("$[1].code").value("MNU"))
            .andExpect(jsonPath("$[2].name").value("Paris Saint-Germain"))
    }

    @Test
    fun `should return team by id`() {
        val team = TeamDTO(1L, 1L, "Bayern Munich", "BAY", "Germany", 1900, false, "https://media.api-sports.io/teams/1.png")

        given(teamService.getTeamById(anyLong())).willReturn(team)

        mockMvc.perform(get("/api/v1/teams/1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.name").value("Bayern Munich"))
            .andExpect(jsonPath("$.code").value("BAY"))
            .andExpect(jsonPath("$.country").value("Germany"))
            .andExpect(jsonPath("$.national").value(false))
    }

    @Test
    fun `should return 404 when team id is not found`() {
        given(teamService.getTeamById(anyLong())).willReturn(null)

        mockMvc.perform(get("/api/v1/teams/999"))
            .andExpect(status().isNotFound)
    }

    @Test
    fun `should return team by name`() {
        val team = TeamDTO(1L, 1L, "Bayern Munich", "BAY", "Germany", 1900, false, "https://media.api-sports.io/teams/1.png")

        given(teamService.getTeamByName(anyString())).willReturn(team)

        mockMvc.perform(get("/api/v1/teams/name/Bayern%20Munich"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.name").value("Bayern Munich"))
            .andExpect(jsonPath("$.code").value("BAY"))
            .andExpect(jsonPath("$.country").value("Germany"))
    }

    @Test
    fun `should return 404 when team name is not found`() {
        given(teamService.getTeamByName(anyString())).willReturn(null)

        mockMvc.perform(get("/api/v1/teams/name/NonExistent"))
            .andExpect(status().isNotFound)
    }

    @Test
    fun `should return team by code`() {
        val team = TeamDTO(1L, 1L, "Bayern Munich", "BAY", "Germany", 1900, false, "https://media.api-sports.io/teams/1.png")

        given(teamService.getTeamByCode(anyString())).willReturn(team)

        mockMvc.perform(get("/api/v1/teams/code/BAY"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.name").value("Bayern Munich"))
            .andExpect(jsonPath("$.code").value("BAY"))
            .andExpect(jsonPath("$.country").value("Germany"))
    }

    @Test
    fun `should return 404 when team code is not found`() {
        given(teamService.getTeamByCode(anyString())).willReturn(null)

        mockMvc.perform(get("/api/v1/teams/code/XYZ"))
            .andExpect(status().isNotFound)
    }

    @Test
    fun `should return teams by country`() {
        val teams = listOf(
            TeamDTO(1L, 1L, "Bayern Munich", "BAY", "Germany", 1900, false, "https://media.api-sports.io/teams/1.png"),
            TeamDTO(4L, null, "Germany", "GER", "Germany", 1908, true, "https://media.api-sports.io/teams/4.png")
        )

        given(teamService.getTeamsByCountry(anyString())).willReturn(teams)

        mockMvc.perform(get("/api/v1/teams/country?country=Germany"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$[0].name").value("Bayern Munich"))
            .andExpect(jsonPath("$[0].country").value("Germany"))
            .andExpect(jsonPath("$[1].name").value("Germany"))
            .andExpect(jsonPath("$[1].national").value(true))
    }

    @Test
    fun `should return empty list when no teams found for country`() {
        given(teamService.getTeamsByCountry(anyString())).willReturn(emptyList())

        mockMvc.perform(get("/api/v1/teams/country?country=NonExistent"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$").isArray)
            .andExpect(jsonPath("$.length()").value(0))
    }

    @Test
    fun `should return national teams`() {
        val teams = listOf(
            TeamDTO(4L, null, "Germany", "GER", "Germany", 1908, true, "https://media.api-sports.io/teams/4.png"),
            TeamDTO(5L, null, "France", "FRA", "France", 1904, true, "https://media.api-sports.io/teams/5.png")
        )

        given(teamService.getTeamsByNational(true)).willReturn(teams)

        mockMvc.perform(get("/api/v1/teams/national?national=true"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$[0].name").value("Germany"))
            .andExpect(jsonPath("$[0].national").value(true))
            .andExpect(jsonPath("$[1].name").value("France"))
            .andExpect(jsonPath("$[1].national").value(true))
    }

    @Test
    fun `should return club teams`() {
        val teams = listOf(
            TeamDTO(1L, 1L, "Bayern Munich", "BAY", "Germany", 1900, false, "https://media.api-sports.io/teams/1.png"),
            TeamDTO(2L, 3L, "Manchester United", "MNU", "England", 1878, false, "https://media.api-sports.io/teams/2.png")
        )

        given(teamService.getTeamsByNational(false)).willReturn(teams)

        mockMvc.perform(get("/api/v1/teams/national?national=false"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$[0].name").value("Bayern Munich"))
            .andExpect(jsonPath("$[0].national").value(false))
            .andExpect(jsonPath("$[1].name").value("Manchester United"))
            .andExpect(jsonPath("$[1].national").value(false))
    }

    @Test
    fun `should return empty list when no national teams found`() {
        given(teamService.getTeamsByNational(true)).willReturn(emptyList())

        mockMvc.perform(get("/api/v1/teams/national?national=true"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$").isArray)
            .andExpect(jsonPath("$.length()").value(0))
    }

    @Test
    fun `should return teams by venue`() {
        val teams = listOf(
            TeamDTO(1L, 1L, "Bayern Munich", "BAY", "Germany", 1900, false, "https://media.api-sports.io/teams/1.png"),
            TeamDTO(6L, 1L, "Another Team", "ANT", "Germany", 2000, false, "https://media.api-sports.io/teams/6.png")
        )

        given(teamService.getTeamsByVenue(anyLong())).willReturn(teams)

        mockMvc.perform(get("/api/v1/teams/venue/1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$[0].name").value("Bayern Munich"))
            .andExpect(jsonPath("$[0].venueId").value(1))
            .andExpect(jsonPath("$[1].name").value("Another Team"))
            .andExpect(jsonPath("$[1].venueId").value(1))
    }

    @Test
    fun `should return empty list when no teams found for venue`() {
        given(teamService.getTeamsByVenue(anyLong())).willReturn(emptyList())

        mockMvc.perform(get("/api/v1/teams/venue/999"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$").isArray)
            .andExpect(jsonPath("$.length()").value(0))
    }
}
