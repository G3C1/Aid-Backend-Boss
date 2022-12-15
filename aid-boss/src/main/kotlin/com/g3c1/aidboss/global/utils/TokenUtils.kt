package com.g3c1.aidboss.global.utils

import com.g3c1.aidboss.domain.user.presentation.data.dto.TokenDto

interface TokenUtils {
    fun getTokenDto(userId: String): TokenDto
}