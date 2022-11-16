package com.g3c1.aidboss.domain.category.utils

import com.g3c1.aidboss.domain.category.domain.entity.Category
import com.g3c1.aidboss.domain.category.presentation.data.dto.CategoryDto
import com.g3c1.aidboss.domain.category.presentation.data.request.CreateCategoryRequest
import com.g3c1.aidboss.domain.store.domain.entity.Store

interface CategoryConverter {
    fun toDto(createCategoryRequest: CreateCategoryRequest): CategoryDto
    fun toEntity(dto: CategoryDto,store:Store): Category
}