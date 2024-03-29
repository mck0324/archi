package com.example.archisketchbackendtest.repository

import com.example.archisketchbackendtest.model.Apartment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface ApartmentRepository: JpaRepository<Apartment, Long>, JpaSpecificationExecutor<Unit> {
}