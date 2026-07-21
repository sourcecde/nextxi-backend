package com.debrajghosh.nextxi.controller

import com.debrajghosh.nextxi.dto.CoachCareerDTO
import com.debrajghosh.nextxi.service.CoachCareerService
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyLong
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.time.LocalDate

@WebMvcTest(CoachCareerController::class)
class CoachCareerControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockitoBean
    lateinit var service: CoachCareerService

    @Test
    fun `should return all careers`() {
        val careers = listOf(
            CoachCareerDTO(1L, 1L, 1L, LocalDate.of(2016, 7, 1), null),
            CoachCareerDTO(2L, 2L, 3L, LocalDate.of(2010, 1, 1), LocalDate.of(2015, 12, 31))
        )

        given(service.getAllCareers()).willReturn(careers)

        mockMvc.perform(get("/api/v1/coach-careers"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$[0].coachId").value(1))
            .andExpect(jsonPath("$[1].teamId").value(3))
    }

    @Test
    fun `should return career by id`() {
        val career = CoachCareerDTO(1L, 1L, 1L, LocalDate.of(2016, 7, 1), null)

        given(service.getCareerById(anyLong())).willReturn(career)

        mockMvc.perform(get("/api/v1/coach-careers/1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.coachId").value(1))
            .andExpect(jsonPath("$.teamId").value(1))
    }

    @Test
    fun `should return careers by coach id`() {
        val careers = listOf(CoachCareerDTO(1L, 1L, 1L, LocalDate.of(2016, 7, 1), null))

        given(service.getCareersByCoach(anyLong())).willReturn(careers)

        mockMvc.perform(get("/api/v1/coach-careers/coach/1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$[0].coachId").value(1))
    }

    @Test
    fun `should return careers by team id`() {
        val careers = listOf(CoachCareerDTO(2L, 2L, 3L, LocalDate.of(2010, 1, 1), LocalDate.of(2015, 12, 31)))

        given(service.getCareersByTeam(anyLong())).willReturn(careers)

        mockMvc.perform(get("/api/v1/coach-careers/team/3"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$[0].teamId").value(3))
    }
}
