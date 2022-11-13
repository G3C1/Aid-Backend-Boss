package com.g3c1.aidboss.domain.user.presentation.data.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.ZonedDateTime

data class TokenDto (
    val accessToken: String,
    val refreshToken: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val expiredAt: ZonedDateTime
)