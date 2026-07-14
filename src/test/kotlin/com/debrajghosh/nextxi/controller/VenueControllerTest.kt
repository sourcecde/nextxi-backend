package com.debrajghosh.nextxi.controller

import com.debrajghosh.nextxi.dto.VenueDTO
import com.debrajghosh.nextxi.service.VenueService
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyInt
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

@WebMvcTest(VenueController::class)
class VenueControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockitoBean
    lateinit var venueService: VenueService

    @Test
    fun `should return all venues`() {
        val venues = listOf(
            VenueDTO(1L, 6, "Allianz Arena", "Werner-Heisenberg-Allee 25", "Munich", "Germany", 75000, "Grass", "https://media.api-sports.io/venues/1.png"),
            VenueDTO(2L, 10, "Olympiastadion", "Olympischer Platz 3", "Berlin", "Germany", 74475, "Grass", "https://media.api-sports.io/venues/10.png")
        )

        given(venueService.getAllVenues()).willReturn(venues)

        mockMvc.perform(get("/api/v1/venues"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$[0].name").value("Allianz Arena"))
            .andExpect(jsonPath("$[0].city").value("Munich"))
            .andExpect(jsonPath("$[1].name").value("Olympiastadion"))
            .andExpect(jsonPath("$[1].city").value("Berlin"))
    }

    @Test
    fun `should return venue by id`() {
        val venue = VenueDTO(1L, 6, "Allianz Arena", "Werner-Heisenberg-Allee 25", "Munich", "Germany", 75000, "Grass", "https://media.api-sports.io/venues/1.png")

        given(venueService.getVenueById(anyLong())).willReturn(venue)

        mockMvc.perform(get("/api/v1/venues/1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.name").value("Allianz Arena"))
            .andExpect(jsonPath("$.city").value("Munich"))
            .andExpect(jsonPath("$.capacity").value(75000))
    }

    @Test
    fun `should return null when venue id is not found`() {
        given(venueService.getVenueById(anyLong())).willReturn(null)

        mockMvc.perform(get("/api/v1/venues/999"))
            .andExpect(status().isOk)
    }

    @Test
    fun `should return venue by api id`() {
        val venue = VenueDTO(1L, 6, "Allianz Arena", "Werner-Heisenberg-Allee 25", "Munich", "Germany", 75000, "Grass", "https://media.api-sports.io/venues/1.png")

        given(venueService.getVenueByApiId(anyInt())).willReturn(venue)

        mockMvc.perform(get("/api/v1/venues/api-id/6"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.name").value("Allianz Arena"))
            .andExpect(jsonPath("$.apiId").value(6))
    }

    @Test
    fun `should return null when venue api id is not found`() {
        given(venueService.getVenueByApiId(anyInt())).willReturn(null)

        mockMvc.perform(get("/api/v1/venues/api-id/999"))
            .andExpect(status().isOk)
    }

    @Test
    fun `should return venue by name`() {
        val venue = VenueDTO(1L, 6, "Allianz Arena", "Werner-Heisenberg-Allee 25", "Munich", "Germany", 75000, "Grass", "https://media.api-sports.io/venues/1.png")

        given(venueService.getVenueByName(anyString())).willReturn(venue)

        mockMvc.perform(get("/api/v1/venues/name/Allianz%20Arena"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.name").value("Allianz Arena"))
            .andExpect(jsonPath("$.city").value("Munich"))
    }

    @Test
    fun `should return null when venue name is not found`() {
        given(venueService.getVenueByName(anyString())).willReturn(null)

        mockMvc.perform(get("/api/v1/venues/name/NonExistent"))
            .andExpect(status().isOk)
    }
}
