package com.debrajghosh.nextxi.country.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "countries")
class Country(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false, length = 255)
    var name: String,

    @Column(nullable = false, unique = true, length = 3)
    var code: String,

    @Column(name = "flag")
    var flag: String? = null,

    @Column(name = "created_at", nullable = false, updatable = false)
    var createdAt: LocalDateTime? = null,

    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime? = null

)