package com.g3c1.aidboss.domain.category.utils

import com.g3c1.aidboss.domain.category.domain.entity.Category
import com.g3c1.aidboss.domain.store.domain.entity.Store

interface CategoryUtils {
    fun findAllCategory(): List<Category>
    fun findById(categoryId: Long): Category
    fun findAllCategoryByStore(store: Store) : List<Category>
}