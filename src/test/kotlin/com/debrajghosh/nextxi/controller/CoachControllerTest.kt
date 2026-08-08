package com.debrajghosh.nextxi.controller

import com.debrajghosh.nextxi.dto.CoachDTO
import com.debrajghosh.nextxi.service.CoachService
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

@WebMvcTest(CoachController::class)
class CoachControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockitoBean
    lateinit var coachService: CoachService

    @Test
    fun `should return all coaches`() {
        val coaches = listOf(
            CoachDTO(1L, 1L, "Pep", "Guardiola", "Pep Guardiola", 52, null, null, null, "Spain", "180", "75", "https://example.com/pep.png"),
            CoachDTO(2L, null, "Jose", "Mourinho", "Jose Mourinho", 58, null, null, null, "Portugal", "175", "72", "https://example.com/jose.png")
        )

        given(coachService.getAllCoaches()).willReturn(coaches)

        mockMvc.perform(get("/api/v1/coaches"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$[0].fullName").value("Pep Guardiola"))
            .andExpect(jsonPath("$[1].fullName").value("Jose Mourinho"))
    }

    @Test
    fun `should return coach by id`() {
        val coach = CoachDTO(1L, 1L, "Pep", "Guardiola", "Pep Guardiola", 52, null, null, null, "Spain", "180", "75", "https://example.com/pep.png")

        given(coachService.getCoachById(anyLong())).willReturn(coach)

        mockMvc.perform(get("/api/v1/coaches/1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.fullName").value("Pep Guardiola"))
            .andExpect(jsonPath("$.nationality").value("Spain"))
    }

    @Test
    fun `should return 404 when coach id not found`() {
        given(coachService.getCoachById(anyLong())).willReturn(null)

        mockMvc.perform(get("/api/v1/coaches/999"))
            .andExpect(status().isNotFound)
    }

    @Test
    fun `should return coach by full name`() {
        val coach = CoachDTO(1L, 1L, "Pep", "Guardiola", "Pep Guardiola", 52, null, null, null, "Spain", "180", "75", "https://example.com/pep.png")

        given(coachService.getCoachByFullName(anyString())).willReturn(coach)

        mockMvc.perform(get("/api/v1/coaches/name/Pep%20Guardiola"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.fullName").value("Pep Guardiola"))
            .andExpect(jsonPath("$.nationality").value("Spain"))
    }

    @Test
    fun `should return coaches by nationality`() {
        val coaches = listOf(CoachDTO(1L, 1L, "Pep", "Guardiola", "Pep Guardiola", 52, null, null, null, "Spain", "180", "75", "https://example.com/pep.png"))

        given(coachService.getCoachesByNationality(anyString())).willReturn(coaches)

        mockMvc.perform(get("/api/v1/coaches/nationality?nationality=Spain"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$[0].nationality").value("Spain"))
    }

    @Test
    fun `should return coaches by current team`() {
        val coaches = listOf(CoachDTO(1L, 1L, "Pep", "Guardiola", "Pep Guardiola", 52, null, null, null, "Spain", "180", "75", "https://example.com/pep.png"))

        given(coachService.getCoachesByCurrentTeam(anyLong())).willReturn(coaches)

        mockMvc.perform(get("/api/v1/coaches/team/1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$[0].currentTeamId").value(1))
    }
}
