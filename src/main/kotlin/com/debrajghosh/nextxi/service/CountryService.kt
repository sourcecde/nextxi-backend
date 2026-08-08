package com.debrajghosh.nextxi.service

import com.debrajghosh.nextxi.dto.CountryDTO
import com.debrajghosh.nextxi.exception.ResourceNotFoundException
import com.debrajghosh.nextxi.repository.CountryRepository
import org.springframework.stereotype.Service

/**
 * Provides read-only operations for country master data.
 */
@Service
class CountryService(private val repository: CountryRepository) {

    /**
     * Retrieves all available countries.
     *
     * @return List of countries.
     */
    fun getAllCountries(): List<CountryDTO> {
        return repository.findAll().map(CountryDTO::fromObject)
    }

    /**
     * Retrieve Country
     * @param id
     * @return Country
     */
    fun getCountryById(id: Long): CountryDTO {
        return repository.findById(id)
            .orElseThrow {
                ResourceNotFoundException("Country not found with id: $id")
            }
            .let(CountryDTO::fromObject)
    }

    /**
     * Retrieve Country
     * @param code
     * @return Country
     */
    fun getCountryByCode(code: String): CountryDTO {
        return repository.findByCode(code.uppercase())
            .orElseThrow {
                ResourceNotFoundException("Country not found with code: $code")
            }
            .let(CountryDTO::fromObject)
    }

    /**
     * Retrieve Country
     * @param countryName
     * @return Country
     */
    fun getCountryByName(countryName: String): CountryDTO {
        return repository.findByName(countryName)
            .orElseThrow {
                ResourceNotFoundException("Country not found with name: $countryName")
            }
            .let(CountryDTO::fromObject)
    }
}