package com.g3c1.aidboss.domain.category.utils.impl

import com.g3c1.aidboss.domain.category.domain.entity.Category
import com.g3c1.aidboss.domain.category.presentation.data.dto.CategoryDto
import com.g3c1.aidboss.domain.category.presentation.data.request.CreateCategoryRequest
import com.g3c1.aidboss.domain.category.utils.CategoryConverter
import org.springframework.stereotype.Component

@Component
class CategoryConverterImpl: CategoryConverter {
    override fun toDto(createCategoryRequest: CreateCategoryRequest): CategoryDto = CategoryDto(createCategoryRequest.categoryList)

    override fun toEntity(dto: CategoryDto): List<Category> = dto.categoryList.toList().map { Category(it) }
}