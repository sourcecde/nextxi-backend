package com.debrajghosh.nextxi.service

import com.debrajghosh.nextxi.factory.VenueFactory
import com.debrajghosh.nextxi.repository.VenueRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.util.Optional

class VenueServiceTest {

    private val repository = Mockito.mock(VenueRepository::class.java)
    private val service = VenueService(repository)

    @Test
    fun `should return all venues`() {
        val venues = listOf(
            VenueFactory.allianzArena(),
            VenueFactory.olympiastadion()
        )

        Mockito.`when`(repository.findAll()).thenReturn(venues)

        val result = service.getAllVenues()

        Assertions.assertEquals(2, result.size)
        Assertions.assertEquals("Allianz Arena", result[0].name)
        Assertions.assertEquals("Munich", result[0].city)
        Assertions.assertEquals("Olympiastadion", result[1].name)
        Assertions.assertEquals("Berlin", result[1].city)
    }

    @Test
    fun `should return venue by id`() {
        val venue = VenueFactory.allianzArena()

        Mockito.`when`(repository.findById(1L)).thenReturn(Optional.of(venue))

        val result = service.getVenueById(1L)

        Assertions.assertEquals(1L, result?.id)
        Assertions.assertEquals("Allianz Arena", result?.name)
        Assertions.assertEquals("Munich", result?.city)
        Assertions.assertEquals(75000, result?.capacity)
    }

    @Test
    fun `should return null when venue id is not found`() {
        Mockito.`when`(repository.findById(99L)).thenReturn(Optional.empty())

        val result = service.getVenueById(99L)

        Assertions.assertNull(result)
    }

    @Test
    fun `should return venue by api id`() {
        val venue = VenueFactory.allianzArena()

        Mockito.`when`(repository.findByApiId(6)).thenReturn(venue)

        val result = service.getVenueByApiId(6)

        Assertions.assertEquals(1L, result?.id)
        Assertions.assertEquals("Allianz Arena", result?.name)
        Assertions.assertEquals(6, result?.apiId)
    }

    @Test
    fun `should return null when venue api id is not found`() {
        Mockito.`when`(repository.findByApiId(999)).thenReturn(null)

        val result = service.getVenueByApiId(999)

        Assertions.assertNull(result)
    }

    @Test
    fun `should return venue by name`() {
        val venue = VenueFactory.stamfordBridge()

        Mockito.`when`(repository.findByName("Stamford Bridge")).thenReturn(venue)

        val result = service.getVenueByName("Stamford Bridge")

        Assertions.assertEquals(3L, result?.id)
        Assertions.assertEquals("Stamford Bridge", result?.name)
        Assertions.assertEquals("London", result?.city)
    }

    @Test
    fun `should return null when venue name is not found`() {
        Mockito.`when`(repository.findByName("NonExistent")).thenReturn(null)

        val result = service.getVenueByName("NonExistent")

        Assertions.assertNull(result)
    }
}
