package com.example.archisketchbackendtest.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class Sigungu (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid_loc_code", nullable = false)
    val pidLocCode: Long = 0,

    @Column(name = "level", nullable = false)
    val level: Byte? = 0,

    @Column(name = "depth1", nullable = false, length = 10)
    val depth1: String? = "none",

    @Column(name = "depth2", nullable = false, length = 10, columnDefinition = "varchar(10) default 'none'")
    val depth2: String? = "none",

    @Column(name = "depth3", nullable = false, length = 10, columnDefinition = "varchar(10) default 'none'")
    val depth3: String? = "none",

    @Column(name = "lt_lng", nullable = false)
    val ltLng: Double? = 0.0,

    @Column(name = "lt_lat", nullable = false)
    val ltLat: Double? = 0.0,

    @Column(name = "rb_lng", nullable = false)
    val rbLng: Double? = 0.0,

    @Column(name = "rb_lat", nullable = false)
    val rbLat: Double? = 0.0,

    @Column(name = "date_creation", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    val dateCreation: LocalDateTime = LocalDateTime.now()
)