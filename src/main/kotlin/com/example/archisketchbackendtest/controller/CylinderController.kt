package com.example.archisketchbackendtest.controller

import com.example.archisketchbackendtest.dto.CylinderResponse
import com.example.archisketchbackendtest.service.CylinderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/cylinder")
class CylinderController(
    private val cylinderService: CylinderService
) {

    @GetMapping("")
    fun getNameAndEditorAsset(): Mono<CylinderResponse> {
        return cylinderService.fetchAndFilterData()

    }

    @PostMapping("/info")
    fun create(@RequestBody request: ReqCreateData): ReqCreateData {
        return cylinderService.create(request)
    }

}

data class ReqCreateData (
    val user: String,
    val password: String
)