package com.debrajghosh.nextxi.repository

import com.debrajghosh.nextxi.entity.Country
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CountryRepository : JpaRepository<Country, Long> {
    fun findByCode(code: String): Country?
    fun findByName(name: String): Country?
}