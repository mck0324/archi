package com.example.archisketchbackendtest.service

import com.example.archisketchbackendtest.model.Address
import com.example.archisketchbackendtest.model.Apartment
import com.example.archisketchbackendtest.model.ApartmentUnit
import com.example.archisketchbackendtest.model.ExtensionType
import com.example.archisketchbackendtest.repository.AddressRepository
import com.example.archisketchbackendtest.repository.ApartmentRepository
import com.example.archisketchbackendtest.repository.ApartmentUnitRepository
import jakarta.persistence.criteria.Subquery
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestParam

@Service
class ApartmentService(
    private val addressRepository: AddressRepository,
    private val apartmentRepository: ApartmentRepository,
    private val apartmentUnitRepository: ApartmentUnitRepository,
) {

    fun findUnits(
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) roadAddress: String?,
        @RequestParam(required = false) lotNumberAddress: String?,
        @RequestParam(required = false) extensionType: ExtensionType?,
        @RequestParam(required = false) typePrefix: String?,
        @RequestParam(required = false) sortOrder: String?
    ): List<ApartmentUnit> {
        println("name,$name")
        println("roadAddress,$roadAddress")
        println("lotNumberAddress,$lotNumberAddress")
        println("extensionType,$extensionType")
        var specifications: Specification<ApartmentUnit> = Specification.where(null)

        if (!name.isNullOrEmpty()) {
            specifications = specifications.and(withName(name))
        } else if (!roadAddress.isNullOrEmpty()) {
            specifications = specifications.and(withRoadAddress(roadAddress))
        } else if (!lotNumberAddress.isNullOrEmpty()) {
            specifications = specifications.and(withLotNumberAddress(lotNumberAddress))
        }

        if (extensionType != null) {
            specifications = specifications?.and(withExtensionType(extensionType)) ?: Specification.where(withExtensionType(extensionType))
        }
        if (!typePrefix.isNullOrEmpty()) {
            specifications = specifications.and(withTypePrefix(typePrefix))
        }

        val sort: Sort = when (sortOrder) {
            "asc" -> Sort.by("exclusiveArea").ascending()
            "desc" -> Sort.by("exclusiveArea").descending()
            else -> Sort.unsorted()
        }
        return apartmentUnitRepository.findAll(specifications, sort)
    }

    fun withName(name: String?): Specification<ApartmentUnit>? {
        return if (name != null) {
            Specification { root, query, cb ->
                cb.equal(root.get<ApartmentUnit>("apartment").get<String>("name"), name)
            }
        } else null
    }
    fun withRoadAddress(roadAddress: String?): Specification<ApartmentUnit>? {
        return if (roadAddress != null) {
            Specification { root, query, cb ->
                val subQuery: Subquery<Long> = query.subquery(Long::class.java)
                val addressRoot = subQuery.from(Address::class.java)
                subQuery.select(addressRoot.get<Apartment>("apartment").get<Long>("id"))
                    .where(cb.equal(addressRoot.get<String>("roadAddress"), roadAddress))
                val apartmentJoin = root.join<ApartmentUnit, Apartment>("apartment")
                cb.`in`(apartmentJoin.get<Long>("id")).value(subQuery)
            }
        } else null
    }
    fun withLotNumberAddress(lotNumberAddress: String?): Specification<ApartmentUnit>? {
        return if (lotNumberAddress != null) {
            Specification { root, query, cb ->
                val subQuery: Subquery<Long> = query.subquery(Long::class.java)
                val addressRoot = subQuery.from(Address::class.java)
                subQuery.select(addressRoot.get<Apartment>("apartment").get<Long>("id"))
                    .where(cb.equal(addressRoot.get<String>("lotNumberAddress"), lotNumberAddress))
                val apartmentJoin = root.join<ApartmentUnit, Apartment>("apartment")
                cb.`in`(apartmentJoin.get<Long>("id")).value(subQuery)
            }
        } else null
    }
    fun withExtensionType(extensionType: ExtensionType?): Specification<ApartmentUnit>? {
        return extensionType?.let {
            Specification { root, _, cb ->
                cb.equal(root.get<ExtensionType>("extensionType"), it)
            }
        }
    }
    fun withTypePrefix(typePrefix: String?): Specification<ApartmentUnit>? {
        return if (!typePrefix.isNullOrEmpty()) {
            Specification { root, _, cb ->
                cb.like(root.get<String>("type"), "$typePrefix%")
            }
        } else null
    }
}