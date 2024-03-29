package com.example.archisketchbackendtest.repository

import com.example.archisketchbackendtest.model.Address
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository: JpaRepository<Address, Long>, JpaSpecificationExecutor<Address> {
}