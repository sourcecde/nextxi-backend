package com.debrajghosh.nextxi.service

import com.debrajghosh.nextxi.repository.CountryRepository
import com.debrajghosh.nextxi.dto.CountryDTO
import org.springframework.stereotype.Service

@Service
class CountryService ( private val repository: CountryRepository) {

    fun getAllCountries(): List<CountryDTO> {
        return repository.findAll().map(CountryDTO::fromObject)
    }

    fun getCountryById(id: Long): CountryDTO? {
        return repository.findById(id)
            .orElse(null)
            ?.let(CountryDTO::fromObject)
    }

    fun getCountryByCode(code: String): CountryDTO? {
        return repository.findByCode(code.uppercase())
            ?.let(CountryDTO::fromObject)
    }

    fun getCountryByName(countryName: String): CountryDTO? {
        return repository.findByName(countryName)?.let(CountryDTO::fromObject)
    }


}