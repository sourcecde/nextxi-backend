package com.debrajghosh.nextxi.service

import com.debrajghosh.nextxi.factory.TeamFactory
import com.debrajghosh.nextxi.repository.TeamRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.util.Optional

class TeamServiceTest {

    private val repository = Mockito.mock(TeamRepository::class.java)
    private val service = TeamService(repository)

    @Test
    fun `should return all teams`() {
        val teams = listOf(
            TeamFactory.bayern(),
            TeamFactory.manchester(),
            TeamFactory.parisStGermain()
        )

        Mockito.`when`(repository.findAll()).thenReturn(teams)

        val result = service.getAllTeams()

        Assertions.assertEquals(3, result.size)
        Assertions.assertEquals("Bayern Munich", result[0].name)
        Assertions.assertEquals("BAY", result[0].code)
        Assertions.assertEquals("Manchester United", result[1].name)
        Assertions.assertEquals("MNU", result[1].code)
        Assertions.assertEquals("Paris Saint-Germain", result[2].name)
        Assertions.assertEquals("PSG", result[2].code)
    }

    @Test
    fun `should return team by id`() {
        val team = TeamFactory.bayern()

        Mockito.`when`(repository.findById(1L)).thenReturn(Optional.of(team))

        val result = service.getTeamById(1L)

        Assertions.assertEquals(1L, result?.id)
        Assertions.assertEquals("Bayern Munich", result?.name)
        Assertions.assertEquals("BAY", result?.code)
        Assertions.assertEquals("Germany", result?.country)
        Assertions.assertEquals(false, result?.national)
    }

    @Test
    fun `should return null when team id is not found`() {
        Mockito.`when`(repository.findById(99L)).thenReturn(Optional.empty())

        val result = service.getTeamById(99L)

        Assertions.assertNull(result)
    }

    @Test
    fun `should return team by name`() {
        val team = TeamFactory.manchester()

        Mockito.`when`(repository.findByName("Manchester United")).thenReturn(team)

        val result = service.getTeamByName("Manchester United")

        Assertions.assertEquals(2L, result?.id)
        Assertions.assertEquals("Manchester United", result?.name)
        Assertions.assertEquals("MNU", result?.code)
        Assertions.assertEquals("England", result?.country)
    }

    @Test
    fun `should return null when team name is not found`() {
        Mockito.`when`(repository.findByName("NonExistent")).thenReturn(null)

        val result = service.getTeamByName("NonExistent")

        Assertions.assertNull(result)
    }

    @Test
    fun `should return team by code`() {
        val team = TeamFactory.parisStGermain()

        Mockito.`when`(repository.findByCode("PSG")).thenReturn(team)

        val result = service.getTeamByCode("PSG")

        Assertions.assertEquals(3L, result?.id)
        Assertions.assertEquals("Paris Saint-Germain", result?.name)
        Assertions.assertEquals("PSG", result?.code)
        Assertions.assertEquals("France", result?.country)
    }

    @Test
    fun `should return null when team code is not found`() {
        Mockito.`when`(repository.findByCode("XYZ")).thenReturn(null)

        val result = service.getTeamByCode("XYZ")

        Assertions.assertNull(result)
    }

    @Test
    fun `should return teams by country`() {
        val teams = listOf(
            TeamFactory.bayern(),
            TeamFactory.germany()
        )

        Mockito.`when`(repository.findByCountry("Germany")).thenReturn(teams)

        val result = service.getTeamsByCountry("Germany")

        Assertions.assertEquals(2, result.size)
        Assertions.assertEquals("Bayern Munich", result[0].name)
        Assertions.assertEquals("Germany", result[1].name)
        Assertions.assertTrue(result[1].national)
    }

    @Test
    fun `should return empty list when no teams found for country`() {
        Mockito.`when`(repository.findByCountry("NonExistent")).thenReturn(emptyList())

        val result = service.getTeamsByCountry("NonExistent")

        Assertions.assertEquals(0, result.size)
    }

    @Test
    fun `should return national teams`() {
        val teams = listOf(
            TeamFactory.germany(),
            TeamFactory.france()
        )

        Mockito.`when`(repository.findByNational(true)).thenReturn(teams)

        val result = service.getTeamsByNational(true)

        Assertions.assertEquals(2, result.size)
        Assertions.assertTrue(result[0].national)
        Assertions.assertTrue(result[1].national)
        Assertions.assertEquals("Germany", result[0].name)
        Assertions.assertEquals("France", result[1].name)
    }

    @Test
    fun `should return club teams`() {
        val teams = listOf(
            TeamFactory.bayern(),
            TeamFactory.manchester()
        )

        Mockito.`when`(repository.findByNational(false)).thenReturn(teams)

        val result = service.getTeamsByNational(false)

        Assertions.assertEquals(2, result.size)
        Assertions.assertFalse(result[0].national)
        Assertions.assertFalse(result[1].national)
        Assertions.assertEquals("Bayern Munich", result[0].name)
        Assertions.assertEquals("Manchester United", result[1].name)
    }

    @Test
    fun `should return empty list when no national teams found`() {
        Mockito.`when`(repository.findByNational(true)).thenReturn(emptyList())

        val result = service.getTeamsByNational(true)

        Assertions.assertEquals(0, result.size)
    }

    @Test
    fun `should return teams by venue id`() {
        val teams = listOf(
            TeamFactory.bayern(),
            TeamFactory.custom(id = 6L, venueId = 1L, name = "Another Team")
        )

        Mockito.`when`(repository.findByVenueId(1L)).thenReturn(teams)

        val result = service.getTeamsByVenue(1L)

        Assertions.assertEquals(2, result.size)
        Assertions.assertEquals(1L, result[0].venueId)
        Assertions.assertEquals(1L, result[1].venueId)
        Assertions.assertEquals("Bayern Munich", result[0].name)
        Assertions.assertEquals("Another Team", result[1].name)
    }

    @Test
    fun `should return empty list when no teams found for venue`() {
        Mockito.`when`(repository.findByVenueId(999L)).thenReturn(emptyList())

        val result = service.getTeamsByVenue(999L)

        Assertions.assertEquals(0, result.size)
    }
}
