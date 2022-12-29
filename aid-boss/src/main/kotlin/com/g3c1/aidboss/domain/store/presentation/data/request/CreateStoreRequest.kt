package com.g3c1.aidboss.domain.store.presentation.data.request

import org.jetbrains.annotations.NotNull

data class CreateStoreRequest (
    @field:NotNull
    val name: String,
    @field:NotNull
    val description: String,
    @field:NotNull
    val img: String
)