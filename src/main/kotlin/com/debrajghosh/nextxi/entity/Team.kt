package com.debrajghosh.nextxi.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ForeignKey
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "teams")
class Team(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "team_id", nullable = false, unique = true)
    var teamId: Long,

    @Column(name = "venue_id")
    var venueId: Long? = null,

    @ManyToOne
    @JoinColumn(name = "venue_id", nullable = true, insertable = false, updatable = false, foreignKey = ForeignKey(name = "fk_team_venue"))
    var venue: Venue? = null,

    @Column(nullable = false, length = 255)
    var name: String,

    @Column(length = 10)
    var code: String? = null,

    @Column(length = 255)
    var country: String? = null,

    @Column
    var founded: Short? = null,

    @Column(nullable = false)
    var national: Boolean = false,

    @Column(columnDefinition = "TEXT")
    var logo: String? = null,

    @Column(name = "created_at", nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()
)
