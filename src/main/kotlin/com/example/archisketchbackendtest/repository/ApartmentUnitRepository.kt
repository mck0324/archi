package com.example.archisketchbackendtest.repository

import com.example.archisketchbackendtest.model.ApartmentUnit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface ApartmentUnitRepository: JpaRepository<ApartmentUnit, Long>, JpaSpecificationExecutor<ApartmentUnit> {
}