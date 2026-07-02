package com.debrajghosh.nextxi.country.service

import com.debrajghosh.nextxi.repository.CountryRepository
import com.debrajghosh.nextxi.factory.CountryFactory
import com.debrajghosh.nextxi.service.CountryService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import java.util.Optional

class CountryServiceTest {

    private val repository = mock(CountryRepository::class.java)
    private val service = CountryService(repository)

    @Test
    fun `should return all countries`() {
        val countries = listOf(
            CountryFactory.austria(),
            CountryFactory.germany()
        )

        `when`(repository.findAll()).thenReturn(countries)

        val result = service.getAllCountries()

        assertEquals(2, result.size)
        assertEquals("Austria", result[0].name)
        assertEquals("AT", result[0].code)
        assertEquals("Germany", result[1].name)
        assertEquals("DE", result[1].code)
    }

    @Test
    fun `should return country by id`() {
        val country = CountryFactory.austria()

        `when`(repository.findById(1L)).thenReturn(Optional.of(country))

        val result = service.getCountryById(1L)

        assertEquals(1L, result?.id)
        assertEquals("Austria", result?.name)
        assertEquals("AT", result?.code)
    }

    @Test
    fun `should return null when country id is not found`() {
        `when`(repository.findById(99L)).thenReturn(Optional.empty())

        val result = service.getCountryById(99L)

        assertNull(result)
    }

    @Test
    fun `should return country by code`() {
        val country = CountryFactory.austria()

        `when`(repository.findByCode("AT")).thenReturn(country)

        val result = service.getCountryByCode("AT")

        assertEquals(1L, result?.id)
        assertEquals("Austria", result?.name)
        assertEquals("AT", result?.code)
    }

    @Test
    fun `should return country by name`() {
        val country = CountryFactory.germany()

        `when`(repository.findByName("Germany")).thenReturn(country)
        val result = service.getCountryByName("Germany")

        assertEquals(country.name, result?.name)
        assertEquals("DE", result?.code)

    }

    @Test
    fun `should return null when country code is not found`() {
        `when`(repository.findByCode("XX")).thenReturn(null)

        val result = service.getCountryByCode("XX")

        assertNull(result)
    }
}