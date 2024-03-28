package com.example.archisketchbackendtest.controller

import com.example.archisketchbackendtest.model.ExtensionType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/apartment")
class ApartmentController {

    @GetMapping("/search")
    fun searchApartment(
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) roadAddress: String?,
        @RequestParam(required = false) lotNumberAddress: String?,
        @RequestParam(required = false) extensionType: ExtensionType?,
        @RequestParam(required = false) typePrefix: String?,
        @RequestParam(required = false) sortOrder: String?
    ): List<Unit> {
        return apartmentService.findUnitsFilteredAndSorted(name, roadAddress, lotNumberAddress, extensionType, typePrefix, sortOrder)
    }
}