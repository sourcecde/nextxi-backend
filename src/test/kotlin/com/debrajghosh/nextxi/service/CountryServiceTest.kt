package com.debrajghosh.nextxi.service

import com.debrajghosh.nextxi.exception.ResourceNotFoundException
import com.debrajghosh.nextxi.factory.CountryFactory
import com.debrajghosh.nextxi.repository.CountryRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.util.Optional

class CountryServiceTest {

    private val repository = Mockito.mock(CountryRepository::class.java)
    private val service = CountryService(repository)

    @Test
    fun `should return all countries`() {
        val countries = listOf(
            CountryFactory.austria(),
            CountryFactory.germany()
        )

        Mockito.`when`(repository.findAll()).thenReturn(countries)

        val result = service.getAllCountries()

        Assertions.assertEquals(2, result.size)
        Assertions.assertEquals("Austria", result[0].name)
        Assertions.assertEquals("AT", result[0].code)
        Assertions.assertEquals("Germany", result[1].name)
        Assertions.assertEquals("DE", result[1].code)
    }

    @Test
    fun `should return country by id`() {
        val country = CountryFactory.austria()

        Mockito.`when`(repository.findById(1L)).thenReturn(Optional.of(country))

        val result = service.getCountryById(1L)

        Assertions.assertEquals(1L, result.id)
        Assertions.assertEquals("Austria", result.name)
        Assertions.assertEquals("AT", result.code)
    }

    @Test
    fun `should throw ResourceNotFoundException when country id is not found`() {
        Mockito.`when`(repository.findById(99L)).thenReturn(Optional.empty())

        Assertions.assertThrows(ResourceNotFoundException::class.java) {
            service.getCountryById(99L)
        }
    }

    @Test
    fun `should return country by code`() {
        val country = CountryFactory.austria()

        Mockito.`when`(repository.findByCode("AT")).thenReturn(Optional.of(country))

        val result = service.getCountryByCode("AT")

        Assertions.assertEquals(1L, result.id)
        Assertions.assertEquals("Austria", result.name)
        Assertions.assertEquals("AT", result.code)
    }

    @Test
    fun `should return country by name`() {
        val country = CountryFactory.germany()

        Mockito.`when`(repository.findByName("Germany")).thenReturn(Optional.of(country))
        val result = service.getCountryByName("Germany")

        Assertions.assertEquals(country.name, result.name)
        Assertions.assertEquals("DE", result.code)

    }

    @Test
    fun `should throw ResourceNotFoundException when country code is not found`() {
        Mockito.`when`(repository.findByCode("XX")).thenReturn(Optional.empty())

        Assertions.assertThrows(ResourceNotFoundException::class.java) {
            service.getCountryByCode("XX")
        }
    }
}