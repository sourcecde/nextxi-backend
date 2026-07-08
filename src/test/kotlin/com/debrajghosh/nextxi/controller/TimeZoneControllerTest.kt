package com.debrajghosh.nextxi.controller

import com.debrajghosh.nextxi.dto.TimeZoneDTO
import com.debrajghosh.nextxi.service.TimeZoneService
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import kotlin.test.Test

@WebMvcTest(controllers = [TimeZoneController::class])
class TimeZoneControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockitoBean
    lateinit var timeZoneService: TimeZoneService

    @Test
    fun `should return all timezones`() {
        `when`(timeZoneService.getAllTimeZones()).thenReturn(
            listOf(
                TimeZoneDTO(1L, "Europe/Vienna"),
                TimeZoneDTO(2L, "Europe/Berlin")
            )
        )
        mockMvc.get("/api/v1/timezones")
            .andExpect {
                status { isOk() }
                jsonPath("$[0].timeZoneName") { value("Europe/Vienna") }
                jsonPath("$[1].timeZoneName") { value("Europe/Berlin") }
            }
    }

    @Test
    fun `should return timezone by id`() {
        val timeZone = TimeZoneDTO(1L, "Europe/Vienna")
        `when`(timeZoneService.getTimeZoneById(1L)).thenReturn(timeZone)
        mockMvc.get("/api/v1/timezones/id/${timeZone.id}", timeZone)
            .andExpect {
                status { isOk() }
                jsonPath("$.timeZoneName") { value("Europe/Vienna") }
            }
    }

    @Test
    fun `should return timezone by name`() {
        val timeZone = TimeZoneDTO(1L, "Europe/Berlin")

        `when`(timeZoneService.getTimeZoneByName("Europe/Berlin"))
            .thenReturn(timeZone)

        mockMvc.get("/api/v1/timezones/timezoneName?name=Europe/Berlin")
            .andExpect {
                status { isOk() }
                jsonPath("$.id") { value(1) }
                jsonPath("$.timeZoneName") { value("Europe/Berlin") }
            }
    }
}