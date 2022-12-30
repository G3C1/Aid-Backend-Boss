package com.g3c1.aidboss.domain.category.service

import com.g3c1.aidboss.domain.category.presentation.data.dto.CategoryDto
import com.g3c1.aidboss.domain.category.presentation.data.dto.CategoryQueryDto

interface CategoryServiceV2 {
    fun createCategory(dto: CategoryDto,serialNumber: Long)
    fun findCategory(serialNumber: Long): List<CategoryQueryDto>
}