package com.example.archisketchbackendtest.model

import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity(name = "tb_user")
@EntityListeners(AuditingEntityListener::class)
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val user: String? = null,
    val password: String? = null,
    val createdAt: LocalDateTime = LocalDateTime.now()

)
