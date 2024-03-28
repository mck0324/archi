package com.example.archisketchbackendtest.repository

import com.example.archisketchbackendtest.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CylinderRepository: JpaRepository<User, Long> {
}