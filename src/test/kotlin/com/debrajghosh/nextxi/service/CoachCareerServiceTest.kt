package com.debrajghosh.nextxi.service

import com.debrajghosh.nextxi.factory.CoachCareerFactory
import com.debrajghosh.nextxi.repository.CoachCareerRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.util.Optional

class CoachCareerServiceTest {

    private val repository = Mockito.mock(CoachCareerRepository::class.java)
    private val service = CoachCareerService(repository)

    @Test
    fun `should return all careers`() {
        val careers = listOf(CoachCareerFactory.career1(), CoachCareerFactory.career2())

        Mockito.`when`(repository.findAll()).thenReturn(careers)

        val result = service.getAllCareers()

        Assertions.assertEquals(2, result.size)
        Assertions.assertEquals(1L, result[0].coachId)
        Assertions.assertEquals(2L, result[1].coachId)
    }

    @Test
    fun `should return career by id`() {
        val career = CoachCareerFactory.career1()

        Mockito.`when`(repository.findById(1L)).thenReturn(Optional.of(career))

        val result = service.getCareerById(1L)

        Assertions.assertEquals(1L, result?.id)
        Assertions.assertEquals(1L, result?.coachId)
        Assertions.assertEquals(1L, result?.teamId)
    }

    @Test
    fun `should return null when career id not found`() {
        Mockito.`when`(repository.findById(99L)).thenReturn(Optional.empty())

        val result = service.getCareerById(99L)

        Assertions.assertNull(result)
    }

    @Test
    fun `should return careers by coach id`() {
        val careers = listOf(CoachCareerFactory.career1())

        Mockito.`when`(repository.findByCoachId(1L)).thenReturn(careers)

        val result = service.getCareersByCoach(1L)

        Assertions.assertEquals(1, result.size)
        Assertions.assertEquals(1L, result[0].coachId)
    }

    @Test
    fun `should return careers by team id`() {
        val careers = listOf(CoachCareerFactory.career2())

        Mockito.`when`(repository.findByTeamId(3L)).thenReturn(careers)

        val result = service.getCareersByTeam(3L)

        Assertions.assertEquals(1, result.size)
        Assertions.assertEquals(3L, result[0].teamId)
    }
}
