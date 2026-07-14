package com.debrajghosh.nextxi.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "venues")
class Venue(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @Column(name = "api_id", nullable = false)
    var apiId: Int,

    @Column(nullable = false, length = 255)
    var name: String,

    @Column(length = 255)
    var address: String? = null,

    @Column(length = 100)
    var city: String? = null,

    @Column(length = 100)
    var country: String? = null,

    @Column
    var capacity: Int? = null,

    @Column(length = 50)
    var surface: String? = null,

    @Column(length = 500)
    var image: String? = null,

    @Column(name = "created_at", nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()
)