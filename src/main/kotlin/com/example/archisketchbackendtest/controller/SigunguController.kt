package com.example.archisketchbackendtest.controller

import com.example.archisketchbackendtest.model.Sigungu
import com.example.archisketchbackendtest.service.SigunguService
import org.apache.coyote.BadRequestException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@RequestMapping("/sigungu")
class SigunguController(
    private val sigunguService: SigunguService
) {

    @GetMapping("")
    fun getByPidData(@RequestParam pidLocCode:Long): Optional<Sigungu> {
        if (pidLocCode == null) {
            throw BadRequestException("pidLocCode 입력해주세요")
        }
        return sigunguService.getByPid(pidLocCode)
    }

}