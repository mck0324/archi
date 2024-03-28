package com.example.archisketchbackendtest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class ArchisketchBackendTestApplication

fun main(args: Array<String>) {
    runApplication<ArchisketchBackendTestApplication>(*args)
}
