package com.example.archisketchbackendtest.controller

import com.example.archisketchbackendtest.model.Sigungu
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sigungu")
class SigunguController {

    @GetMapping("")
    fun getByPidData(@RequestParam pidLocCode:Long): Sigungu {

    }

}