package com.g3c1.aidboss.domain.category.utils

import com.g3c1.aidboss.domain.category.domain.entity.Category

interface CategoryUtils {
    fun findAllCategory(): List<Category>
}