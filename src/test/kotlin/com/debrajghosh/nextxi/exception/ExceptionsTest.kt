package com.debrajghosh.nextxi.exception

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus

class ExceptionsTest {

    private val exceptionHandler = GlobalExceptionHandler()

    @Test
    fun `should throw ResourceNotFoundException and return 404 response`() {
        val ex = ResourceNotFoundException("Resource with ID 1 not found")
        assertEquals("Resource with ID 1 not found", ex.message)

        val response = exceptionHandler.handleResourceNotFoundException(ex)
        assertEquals(HttpStatus.NOT_FOUND, response.statusCode)
        assertEquals(404, response.body?.status)
        assertEquals("Not Found", response.body?.error)
        assertEquals("Resource with ID 1 not found", response.body?.message)
        assertNotNull(response.body?.timestamp)
    }

    @Test
    fun `should throw BadRequestException and return 400 response`() {
        val ex = BadRequestException("Invalid parameter")
        assertEquals("Invalid parameter", ex.message)

        val response = exceptionHandler.handleBadRequestException(ex)
        assertEquals(HttpStatus.BAD_REQUEST, response.statusCode)
        assertEquals(400, response.body?.status)
        assertEquals("Bad Request", response.body?.error)
        assertEquals("Invalid parameter", response.body?.message)
    }

    @Test
    fun `should throw DuplicateResourceException and return 409 response`() {
        val ex = DuplicateResourceException("Already exists")
        assertEquals("Already exists", ex.message)

        val response = exceptionHandler.handleDuplicateResourceException(ex)
        assertEquals(HttpStatus.CONFLICT, response.statusCode)
        assertEquals(409, response.body?.status)
        assertEquals("Conflict", response.body?.error)
        assertEquals("Already exists", response.body?.message)
    }

    @Test
    fun `should throw UnauthorizedException and return 401 response`() {
        val ex = UnauthorizedException("Access denied")
        assertEquals("Access denied", ex.message)

        val response = exceptionHandler.handleUnauthorizedException(ex)
        assertEquals(HttpStatus.UNAUTHORIZED, response.statusCode)
        assertEquals(401, response.body?.status)
        assertEquals("Unauthorized", response.body?.error)
        assertEquals("Access denied", response.body?.message)
    }

    @Test
    fun `should handle generic NextxiException`() {
        val ex = NextxiException("Internal application error")
        val response = exceptionHandler.handleNextxiException(ex)
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.statusCode)
        assertEquals(500, response.body?.status)
        assertEquals("Internal application error", response.body?.message)
    }
}
