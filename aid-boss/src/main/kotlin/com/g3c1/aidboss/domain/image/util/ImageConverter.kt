package com.g3c1.aidboss.domain.image.util

import com.g3c1.aidboss.domain.image.presentation.data.dto.ImageDto
import com.g3c1.aidboss.domain.image.presentation.data.resposne.ImageResponse

interface ImageConverter {
    fun toResponse(dto: ImageDto): ImageResponse
}