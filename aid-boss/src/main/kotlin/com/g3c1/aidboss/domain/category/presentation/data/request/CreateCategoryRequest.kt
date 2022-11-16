package com.g3c1.aidboss.domain.category.presentation.data.request

import org.jetbrains.annotations.NotNull

data class CreateCategoryRequest (
    @field:NotNull
    val categoryName: String
)
