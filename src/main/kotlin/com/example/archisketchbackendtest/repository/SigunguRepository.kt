package com.example.archisketchbackendtest.repository

import com.example.archisketchbackendtest.model.Sigungu
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface SigunguRepository: JpaRepository<Sigungu, Long> {

    fun findByPidLocCode(pidCode: Long): Optional<Sigungu>
}