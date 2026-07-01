package com.debrajghosh.nextxi.controller

import com.debrajghosh.nextxi.dto.CountryDTO
import com.debrajghosh.nextxi.service.CountryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/countries")
class CountryController(
    private val countryService: CountryService
) {

    @GetMapping
    fun getAllCountries(): List<CountryDTO> {
        return countryService.getAllCountries()
    }

    @GetMapping("/{id}")
    fun getCountryById(@PathVariable id: Long): CountryDTO? {
        return countryService.getCountryById(id)
    }

    @GetMapping("/code/{code}")
    fun getCountryByCode(@PathVariable code: String): CountryDTO? {
        return countryService.getCountryByCode(code)
    }
}