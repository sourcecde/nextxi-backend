package com.debrajghosh.nextxi.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * Base custom runtime exception for NextXI application.
 */
open class NextxiException(
    override val message: String,
    cause: Throwable? = null
) : RuntimeException(message, cause)

/**
 * Exception thrown when a requested resource is not found (HTTP 404).
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
class ResourceNotFoundException(
    message: String
) : NextxiException(message)

/**
 * Exception thrown when a request contains invalid or malformed data (HTTP 400).
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
class BadRequestException(
    message: String
) : NextxiException(message)

/**
 * Exception thrown when a resource already exists or conflicts (HTTP 409).
 */
@ResponseStatus(HttpStatus.CONFLICT)
class DuplicateResourceException(
    message: String
) : NextxiException(message)

/**
 * Exception thrown when authentication or authorization fails (HTTP 401).
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
class UnauthorizedException(
    message: String
) : NextxiException(message)
