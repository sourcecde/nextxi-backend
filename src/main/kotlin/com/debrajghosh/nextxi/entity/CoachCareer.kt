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
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "coach_careers")
class CoachCareer(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "coach_id", nullable = false)
    var coachId: Long,

    @Column(name = "team_id", nullable = false)
    var teamId: Long,

    @ManyToOne
    @JoinColumn(name = "coach_id", nullable = false, insertable = false, updatable = false, foreignKey = ForeignKey(name = "fk_coach_career_coach"))
    var coach: Coach? = null,

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false, insertable = false, updatable = false, foreignKey = ForeignKey(name = "fk_coach_career_team"))
    var team: Team? = null,

    @Column(name = "start_date", nullable = false)
    var startDate: LocalDate,

    @Column(name = "end_date")
    var endDate: LocalDate? = null,

    @Column(name = "created_at", nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()
)
