package com.g3c1.aidboss

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class AidBossApplication


fun main(args: Array<String>) {
    runApplication<AidBossApplication>(*args)
}
