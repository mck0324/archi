package com.example.archisketchbackendtest.service

import com.example.archisketchbackendtest.model.Sigungu
import com.example.archisketchbackendtest.repository.SigunguRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestParam
import java.util.Optional

@Service
class SigunguService(
    private val sigunguRepository: SigunguRepository
) {

    fun getByPid(@RequestParam pidLocCode:Long): Optional<Sigungu> {
        return sigunguRepository.findByPidLocCode(pidLocCode)

//        return sigunguRepository.findById(pidLocCode)
    }
}