package com.g3c1.aidboss.domain.store.presentation.data.dto

data class CreateStoreDto (
    val serialNumber: Long,
    val name: String,
    val description: String,
    val img: String
)