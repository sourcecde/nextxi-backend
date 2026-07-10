package com.debrajghosh.nextxi.factory

import com.debrajghosh.nextxi.entity.Country

object CountryFactory {

    fun austria() = Country(
        id = 1L,
        name = "Austria",
        code = "AT",
        flag = "https://flagcdn.com/at.svg"
    )

    fun germany() = Country(
        id = 2L,
        name = "Germany",
        code = "DE",
        flag = "https://flagcdn.com/de.svg"
    )

    fun france() = Country(
        id = 3L,
        name = "France",
        code = "FR",
        flag = "https://flagcdn.com/fr.svg"
    )

    fun custom(
        id: Long = 1L,
        name: String = "Austria",
        code: String = "AT",
        flag: String? = "https://flagcdn.com/at.svg"
    ) = Country(
        id = id,
        name = name,
        code = code,
        flag = flag
    )
}