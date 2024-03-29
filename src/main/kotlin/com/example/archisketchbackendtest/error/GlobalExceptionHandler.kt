package com.example.archisketchbackendtest.error

import jakarta.persistence.EntityNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException::class)
    fun handleEntityNotFoundException(exception: EntityNotFoundException): ResponseEntity<Any> {
        val body = mapOf("message" to (exception.message ?: "Resource not found"))
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(exception: IllegalArgumentException): ResponseEntity<Any> {
        val body = mapOf("message" to (exception.message ?: "Invalid argument"))
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body)
    }

}