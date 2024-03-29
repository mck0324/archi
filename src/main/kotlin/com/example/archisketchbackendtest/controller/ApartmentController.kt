package com.example.archisketchbackendtest.controller

import com.example.archisketchbackendtest.model.ApartmentUnit
import com.example.archisketchbackendtest.model.ExtensionType
import com.example.archisketchbackendtest.service.ApartmentService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/apartment")
class ApartmentController(
    private val apartmentService: ApartmentService
) {

    @GetMapping("/search")
    fun searchApartment(
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) roadAddress: String?,
        @RequestParam(required = false) lotNumberAddress: String?,
        @RequestParam(required = false) extensionType: ExtensionType?,
        @RequestParam(required = false) typePrefix: String?,
        @RequestParam(required = false) sortOrder: String?
    ): List<ApartmentUnit> {
        if (name.isNullOrBlank() && roadAddress.isNullOrBlank() && lotNumberAddress.isNullOrBlank()) {
            throw IllegalArgumentException("적어도 한가지 이상의 파라미터를 제공해줘야합니다.")
        }

        return apartmentService.findUnits(name, roadAddress, lotNumberAddress, extensionType, typePrefix, sortOrder)
    }
}