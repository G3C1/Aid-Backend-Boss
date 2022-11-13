package com.g3c1.aidboss.global.redis.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "spring.redis")
data class RedisProperties (
    val host: String,
    val port: Int
)