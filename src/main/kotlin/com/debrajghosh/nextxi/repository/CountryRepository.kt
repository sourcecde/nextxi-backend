package com.debrajghosh.nextxi.repository

import com.debrajghosh.nextxi.entity.Country
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface CountryRepository : JpaRepository<Country, Long> {
    fun findByCode(code: String): Optional<Country>
    fun findByName(name: String): Optional<Country>
}