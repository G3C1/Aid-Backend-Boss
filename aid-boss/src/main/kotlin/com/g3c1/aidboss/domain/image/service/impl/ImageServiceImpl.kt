package com.g3c1.aidboss.domain.image.service.impl


import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import com.g3c1.aidboss.domain.image.Exception.FailUploadImageException
import com.g3c1.aidboss.domain.image.presentation.data.dto.ImageDto
import com.g3c1.aidboss.domain.image.service.ImageService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.util.*


@Service
class ImageServiceImpl(
    private val amazonS3: AmazonS3,
): ImageService {
    @Value("\${cloud.aws.s3.bucket}")
    lateinit var bucket: String

    @Value("\${cloud.aws.s3.url}")
    lateinit var url: String


    override fun uploadImage(multipartFile: MultipartFile): ImageDto {
        val fileName: String = createFileName(multipartFile.originalFilename.toString())
        val objectMetadata = ObjectMetadata()
        objectMetadata.contentLength = multipartFile.size
        objectMetadata.contentType = multipartFile.contentType
        try {
            multipartFile.inputStream.use { inputStream ->
                amazonS3.putObject(
                    PutObjectRequest(bucket, fileName, inputStream, objectMetadata)
                        .withCannedAcl(CannedAccessControlList.PublicRead)
                )
            }
        } catch (e: IOException) {
            throw FailUploadImageException()
        }
        return ImageDto(url+fileName)
    }
    private fun createFileName(fileName: String): String {
        return UUID.randomUUID().toString()
    }

}