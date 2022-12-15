package com.g3c1.aidboss.domain.category.service

import com.g3c1.aidboss.domain.category.presentation.data.dto.CategoryDto

interface CategoryService {
    fun createCategory(dto: CategoryDto)
}