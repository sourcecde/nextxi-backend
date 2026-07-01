package com.debrajghosh.nextxi.dto

import com.debrajghosh.nextxi.country.entity.Country

data class CountryDTO(
    val id: Long?,
    val name: String,
    val code: String,
    val flag: String?,
){
    companion object{
        fun fromObject(country: Country): CountryDTO {
            return CountryDTO(
                id = country.id,
                name = country.name,
                code = country.code,
                flag = country.flag,
            )
        }
    }
}