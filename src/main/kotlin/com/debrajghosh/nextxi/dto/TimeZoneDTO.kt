package com.debrajghosh.nextxi.dto

import com.debrajghosh.nextxi.entity.TimeZone

data class TimeZoneDTO (
    val id: Long,
    val timeZoneName: String,

){
    companion object{
        fun fromObject(timeZone: TimeZone): TimeZoneDTO {
            return TimeZoneDTO (
                id = timeZone.id,
                timeZoneName = timeZone.timeZoneName,
            )
        }
    }
}