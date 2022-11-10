package com.g3c1.aidboss.global.security.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
class JwtProperties (
    val accessSecret: String,
    val refreshSecret: String
)