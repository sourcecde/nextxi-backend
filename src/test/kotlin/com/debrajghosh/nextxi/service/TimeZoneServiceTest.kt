package com.debrajghosh.nextxi.service

import com.debrajghosh.nextxi.entity.TimeZone
import com.debrajghosh.nextxi.exception.ResourceNotFoundException
import com.debrajghosh.nextxi.repository.TimeZoneRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.util.Optional

class TimeZoneServiceTest {

    private val repository = Mockito.mock(TimeZoneRepository::class.java)
    private val timeZoneService = TimeZoneService(repository)

    @Test
    fun `should return all timezones`() {
        val timeZones = TimeZone(
            id = 1,
            timeZoneName = "Europe/Vienna",
        )
        Mockito.`when`(repository.findAll()).thenReturn(listOf(timeZones))
        val result = timeZoneService.getAllTimeZones()

        Assertions.assertEquals(1, result.size)
        Assertions.assertEquals("Europe/Vienna", result[0].timeZoneName)
    }

    @Test
    fun `should return timezone by name`() {

        val timeZone = TimeZone(
            id = 1L,
            timeZoneName = "Europe/Vienna"
        )

        Mockito.`when`(
            repository.findByTimeZoneName("Europe/Vienna")
        ).thenReturn(Optional.of(timeZone))

        val result = timeZoneService.getTimeZoneByName("Europe/Vienna")

        Assertions.assertNotNull(result)
        Assertions.assertEquals(1L, result.id)
        Assertions.assertEquals("Europe/Vienna", result.timeZoneName)
    }

    @Test
    fun `should throw ResourceNotFoundException when timezone is not found`() {

        Mockito.`when`(
            repository.findByTimeZoneName("Europe/Vienna")
        ).thenReturn(Optional.empty())

        Assertions.assertThrows(ResourceNotFoundException::class.java) {
            timeZoneService.getTimeZoneByName("Europe/Vienna")
        }
    }
}