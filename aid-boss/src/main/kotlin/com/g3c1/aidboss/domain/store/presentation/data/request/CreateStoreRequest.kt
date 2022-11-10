package com.g3c1.aidboss.domain.store.presentation.data.request

data class CreateStoreRequest (
    val serialNumber: Long,
    val name: String,
    val description: String,
    val img: String
)