package com.g3c1.aidboss.domain.image.presentation

import com.g3c1.aidboss.domain.image.presentation.data.resposne.ImageResponse
import com.g3c1.aidboss.domain.image.service.ImageService
import com.g3c1.aidboss.domain.image.util.ImageConverter
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import javax.validation.Valid

@RestController
@RequestMapping("api/v2/image")
class ImageController(
    private val imageService: ImageService,
    private val imageConverter: ImageConverter
) {
    @PostMapping
    fun uploadFile(@Valid @RequestPart(value = "file",) multipartFile: MultipartFile): ResponseEntity<ImageResponse> =
        imageService.uploadImage(multipartFile)
            .let { imageConverter.toResponse(it) }
            .let { ResponseEntity.ok().body(it) }
}