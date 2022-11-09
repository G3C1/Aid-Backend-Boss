package com.g3c1.aidboss.domain.category.utils

import com.g3c1.aidboss.domain.category.domain.entity.Category
import com.g3c1.aidboss.domain.category.presentation.data.dto.CategoryDto
import com.g3c1.aidboss.domain.category.presentation.data.request.CreateCategoryRequest

interface CategoryConverter {
    fun toDto(createCategoryRequest: CreateCategoryRequest): CategoryDto
    fun toEntity(dto: CategoryDto): List<Category>
}