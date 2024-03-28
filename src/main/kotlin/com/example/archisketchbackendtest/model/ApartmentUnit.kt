package com.example.archisketchbackendtest.model

import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity(name = "tb_apartment_unit")
@EntityListeners(AuditingEntityListener::class)
class ApartmentUnit (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val exclusiveArea: BigDecimal? = null,

    val suppliedArea: BigDecimal? = null,

    val blueprintImage: String? = null,

    val type: String? = null,

    val extensionType: ExtensionType? = ExtensionType.BASIC,

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    val apartment: Apartment? = null,

    @CreatedDate
    var createdAt: LocalDateTime? = null,
    @LastModifiedDate
    var updatedAt: LocalDateTime? = null,

    )
enum class ExtensionType {
    BASIC, EXTENDED
}