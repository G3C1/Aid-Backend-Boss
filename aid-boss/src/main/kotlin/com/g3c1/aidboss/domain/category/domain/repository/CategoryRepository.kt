package com.g3c1.aidboss.domain.category.domain.repository

import com.g3c1.aidboss.domain.category.domain.entity.Category
import org.springframework.data.repository.CrudRepository

interface CategoryRepository: CrudRepository<Category,Long> {
}