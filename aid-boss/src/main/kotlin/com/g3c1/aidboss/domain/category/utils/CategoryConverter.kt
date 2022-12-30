package com.g3c1.aidboss.domain.category.utils

import com.g3c1.aidboss.domain.category.domain.entity.Category
import com.g3c1.aidboss.domain.category.presentation.data.dto.CategoryDto
import com.g3c1.aidboss.domain.category.presentation.data.dto.CategoryQueryDto
import com.g3c1.aidboss.domain.category.presentation.data.request.CreateCategoryRequest
import com.g3c1.aidboss.domain.category.presentation.data.response.CategoryResponse
import com.g3c1.aidboss.domain.store.domain.entity.Store

interface CategoryConverter {
    fun toDto(request: CreateCategoryRequest): CategoryDto
    fun toDto(entity: Category): CategoryQueryDto
    fun toEntity(dto: CategoryDto, entity: Store): Category
    fun toResponse(dto: CategoryQueryDto): CategoryResponse
}