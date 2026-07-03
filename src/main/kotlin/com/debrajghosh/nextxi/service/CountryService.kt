package com.debrajghosh.nextxi.service

import com.debrajghosh.nextxi.repository.CountryRepository
import com.debrajghosh.nextxi.dto.CountryDTO
import org.springframework.stereotype.Service

/**
 * Provides read-only operations for country master data.
 */
@Service
class CountryService ( private val repository: CountryRepository) {

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
    fun getCountryById(id: Long): CountryDTO? {
        return repository.findById(id)
            .orElse(null)
            ?.let(CountryDTO::fromObject)
    }

    /**
     * Retrieve Country
     * @param code
     * @return Country
     */

    fun getCountryByCode(code: String): CountryDTO? {
        return repository.findByCode(code.uppercase())
            ?.let(CountryDTO::fromObject)
    }

    /**
     * Retrieve Country
     * @param countryName
     * @return Country
     */

    fun getCountryByName(countryName: String): CountryDTO? {
        return repository.findByName(countryName)?.let(CountryDTO::fromObject)
    }


}