package com.g3c1.aidboss.domain.category.utils.impl

import com.g3c1.aidboss.domain.category.domain.entity.Category
import com.g3c1.aidboss.domain.category.presentation.data.dto.CategoryDto
import com.g3c1.aidboss.domain.category.presentation.data.dto.CategoryQueryDto
import com.g3c1.aidboss.domain.category.presentation.data.request.CreateCategoryRequest
import com.g3c1.aidboss.domain.category.presentation.data.response.CategoryResponse
import com.g3c1.aidboss.domain.category.utils.CategoryConverter
import com.g3c1.aidboss.domain.store.domain.entity.Store
import org.springframework.stereotype.Component

@Component
class
CategoryConverterImpl: CategoryConverter {
    override fun toDto(request: CreateCategoryRequest): CategoryDto = CategoryDto(request.categoryName)
    override fun toDto(entity: Category): CategoryQueryDto = CategoryQueryDto(entity.id, entity.name)

    override fun toEntity(dto: CategoryDto, entity: Store): Category = Category(dto.categoryName,entity)
    override fun toResponse(dto: CategoryQueryDto): CategoryResponse = CategoryResponse(dto.categoryId, dto.categoryName)
}