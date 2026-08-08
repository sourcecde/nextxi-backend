package com.debrajghosh.nextxi.service

import com.debrajghosh.nextxi.factory.CoachFactory
import com.debrajghosh.nextxi.repository.CoachRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.util.Optional

class CoachServiceTest {

    private val repository = Mockito.mock(CoachRepository::class.java)
    private val service = CoachService(repository)

    @Test
    fun `should return all coaches`() {
        val coaches = listOf(CoachFactory.guardiola(), CoachFactory.mourinho())

        Mockito.`when`(repository.findAll()).thenReturn(coaches)

        val result = service.getAllCoaches()

        Assertions.assertEquals(2, result.size)
        Assertions.assertEquals("Pep Guardiola", result[0].fullName)
        Assertions.assertEquals("Jose Mourinho", result[1].fullName)
    }

    @Test
    fun `should return coach by id`() {
        val coach = CoachFactory.guardiola()

        Mockito.`when`(repository.findById(1L)).thenReturn(Optional.of(coach))

        val result = service.getCoachById(1L)

        Assertions.assertEquals(1L, result?.id)
        Assertions.assertEquals("Pep Guardiola", result?.fullName)
        Assertions.assertEquals("Spain", result?.nationality)
    }

    @Test
    fun `should return null when coach id is not found`() {
        Mockito.`when`(repository.findById(99L)).thenReturn(Optional.empty())

        val result = service.getCoachById(99L)

        Assertions.assertNull(result)
    }

    @Test
    fun `should return coach by full name`() {
        val coach = CoachFactory.mourinho()

        Mockito.`when`(repository.findByFullName("Jose Mourinho")).thenReturn(coach)

        val result = service.getCoachByFullName("Jose Mourinho")

        Assertions.assertEquals(2L, result?.id)
        Assertions.assertEquals("Jose Mourinho", result?.fullName)
        Assertions.assertEquals("Portugal", result?.nationality)
    }

    @Test
    fun `should return null when coach name not found`() {
        Mockito.`when`(repository.findByFullName("NonExistent")).thenReturn(null)

        val result = service.getCoachByFullName("NonExistent")

        Assertions.assertNull(result)
    }

    @Test
    fun `should return coaches by nationality`() {
        val coaches = listOf(CoachFactory.guardiola())

        Mockito.`when`(repository.findByNationality("Spain")).thenReturn(coaches)

        val result = service.getCoachesByNationality("Spain")

        Assertions.assertEquals(1, result.size)
        Assertions.assertEquals("Pep Guardiola", result[0].fullName)
    }

    @Test
    fun `should return coaches by current team id`() {
        val coaches = listOf(CoachFactory.guardiola())

        Mockito.`when`(repository.findByCurrentTeamId(1L)).thenReturn(coaches)

        val result = service.getCoachesByCurrentTeam(1L)

        Assertions.assertEquals(1, result.size)
        Assertions.assertEquals(1L, result[0].currentTeamId)
    }
}
