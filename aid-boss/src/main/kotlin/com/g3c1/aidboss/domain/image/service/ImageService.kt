package com.g3c1.aidboss.domain.image.service

import com.g3c1.aidboss.domain.image.presentation.data.dto.ImageDto
import org.springframework.web.multipart.MultipartFile

interface ImageService {
    fun uploadImage(multipartFile: MultipartFile): ImageDto
}