package com.debrajghosh.nextxi.dto
import com.debrajghosh.nextxi.entity.Venue

data class VenueDTO(
    val id: Long,
    val apiId: Int,
    val name: String,
    val address: String?,
    val city: String?,
    val country: String?,
    val capacity: Int?,
    val surface: String?,
    val image: String?,
) {
    companion object {
        fun fromObject(venue: Venue): VenueDTO {
            return VenueDTO(
                id = venue.id,
                apiId = venue.apiId,
                name = venue.name,
                address = venue.address,
                city = venue.city,
                country = venue.country,
                capacity = venue.capacity,
                surface = venue.surface,
                image = venue.image,
            )
        }
    }
}