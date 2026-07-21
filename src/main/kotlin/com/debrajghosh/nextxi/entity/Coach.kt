package com.debrajghosh.nextxi.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ForeignKey
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "coaches")
class Coach(

    @Id
    var id: Long,

    @Column(name = "current_team_id")
    var currentTeamId: Long? = null,

    @ManyToOne
    @JoinColumn(name = "current_team_id", nullable = true, insertable = false, updatable = false, foreignKey = ForeignKey(name = "fk_coach_current_team"))
    var currentTeam: Team? = null,

    @Column(name = "first_name", length = 255)
    var firstName: String? = null,

    @Column(name = "last_name", length = 255)
    var lastName: String? = null,

    @Column(name = "full_name", nullable = false, length = 255)
    var fullName: String,

    @Column
    var age: Short? = null,

    @Column(name = "birth_date")
    var birthDate: LocalDate? = null,

    @Column(name = "birth_place", length = 255)
    var birthPlace: String? = null,

    @Column(name = "birth_country", length = 255)
    var birthCountry: String? = null,

    @Column(length = 255)
    var nationality: String? = null,

    @Column(length = 20)
    var height: String? = null,

    @Column(length = 20)
    var weight: String? = null,

    @Column(columnDefinition = "TEXT")
    var photo: String? = null,

    @Column(name = "created_at", nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()
)
