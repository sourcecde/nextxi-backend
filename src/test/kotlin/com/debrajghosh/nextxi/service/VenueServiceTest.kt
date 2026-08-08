package com.debrajghosh.nextxi.service

import com.debrajghosh.nextxi.exception.ResourceNotFoundException
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

        Assertions.assertEquals(1L, result.id)
        Assertions.assertEquals("Allianz Arena", result.name)
        Assertions.assertEquals("Munich", result.city)
        Assertions.assertEquals(75000, result.capacity)
    }

    @Test
    fun `should throw ResourceNotFoundException when venue id is not found`() {
        Mockito.`when`(repository.findById(99L)).thenReturn(Optional.empty())

        Assertions.assertThrows(ResourceNotFoundException::class.java) {
            service.getVenueById(99L)
        }
    }

    @Test
    fun `should return venue by api id`() {
        val venue = VenueFactory.allianzArena()

        Mockito.`when`(repository.findByVenueId(6)).thenReturn(Optional.of(venue))

        val result = service.getVenueByVenueId(6)

        Assertions.assertEquals(1L, result.id)
        Assertions.assertEquals("Allianz Arena", result.name)
        Assertions.assertEquals(6, result.venueId)
    }

    @Test
    fun `should throw ResourceNotFoundException when venue api id is not found`() {
        Mockito.`when`(repository.findByVenueId(999)).thenReturn(Optional.empty())

        Assertions.assertThrows(ResourceNotFoundException::class.java) {
            service.getVenueByVenueId(999)
        }
    }

    @Test
    fun `should return venue by name`() {
        val venue = VenueFactory.stamfordBridge()

        Mockito.`when`(repository.findByName("Stamford Bridge")).thenReturn(Optional.of(venue))

        val result = service.getVenueByName("Stamford Bridge")

        Assertions.assertEquals(3L, result.id)
        Assertions.assertEquals("Stamford Bridge", result.name)
        Assertions.assertEquals("London", result.city)
    }

    @Test
    fun `should throw ResourceNotFoundException when venue name is not found`() {
        Mockito.`when`(repository.findByName("NonExistent")).thenReturn(Optional.empty())

        Assertions.assertThrows(ResourceNotFoundException::class.java) {
            service.getVenueByName("NonExistent")
        }
    }
}
