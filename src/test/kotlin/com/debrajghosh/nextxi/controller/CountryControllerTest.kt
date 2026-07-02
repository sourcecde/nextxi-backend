package com.debrajghosh.nextxi.country.controller

import com.debrajghosh.nextxi.controller.CountryController
import com.debrajghosh.nextxi.dto.CountryDTO
import com.debrajghosh.nextxi.service.CountryService
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.BDDMockito.given
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath

@WebMvcTest(CountryController::class)
class CountryControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockitoBean
    lateinit var countryService: CountryService

    @Test
    fun `should return all countries`() {
        `when`(countryService.getAllCountries()).thenReturn(
            listOf(
                CountryDTO(1L, "Austria", "AT", "https://flagcdn.com/at.svg"),
                CountryDTO(2L, "Germany", "DE", "https://flagcdn.com/de.svg")
            )
        )

        mockMvc.get("/api/v1/countries")
            .andExpect {
                status { isOk() }
                jsonPath("$[0].name") { value("Austria") }
                jsonPath("$[0].code") { value("AT") }
                jsonPath("$[1].name") { value("Germany") }
                jsonPath("$[1].code") { value("DE") }
            }
    }

    @Test
    fun `should return country by code`() {
        val country = CountryDTO(1L, "Austria", "AT", "https://flagcdn.com/svg")

        given(countryService.getCountryByCode(anyString())).willReturn(country)

        mockMvc.perform(get("/api/v1/countries/code/${country.code}"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.name").value("Austria"))
            .andExpect(jsonPath("$.code").value("AT"))
    }

    @Test
    fun `should return country by id`() {
        val country = CountryDTO(1L, "Austria", "AT", "https://flagcdn.com/svg")

        given(countryService.getCountryById(1L))
            .willReturn(country)
        mockMvc.perform(get("/api/v1/countries/${country.id}"))
        .andExpect(status().isOk)
        .andExpect(jsonPath("$.name").value("Austria"))
        .andExpect(jsonPath("$.code").value("AT"))

    }

    @Test
    fun `should return country by name`() {

        val country = CountryDTO(
            id = 1L,
            name = "France",
            code = "FR",
            flag = "https://flagcdn.com/at.svg"
        )

        given(countryService.getCountryByName("France"))
            .willReturn(country)

        mockMvc.perform(get("/api/v1/countries/name/${country.name}"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.name").value("France"))
            .andExpect(jsonPath("$.code").value("FR"))
            .andExpect(jsonPath("$.flag").value("https://flagcdn.com/at.svg"))
    }
}