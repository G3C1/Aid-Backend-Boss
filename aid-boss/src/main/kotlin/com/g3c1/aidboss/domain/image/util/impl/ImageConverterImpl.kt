package com.g3c1.aidboss.domain.image.util.impl

import com.g3c1.aidboss.domain.image.presentation.data.dto.ImageDto
import com.g3c1.aidboss.domain.image.presentation.data.resposne.ImageResponse
import com.g3c1.aidboss.domain.image.util.ImageConverter
import org.springframework.stereotype.Component

@Component
class ImageConverterImpl: ImageConverter{
    override fun toResponse(dto: ImageDto): ImageResponse = ImageResponse(dto.imageUrl)
}