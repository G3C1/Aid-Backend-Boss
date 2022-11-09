package com.g3c1.aidboss.domain.category.domain.repository

import com.g3c1.aidboss.domain.category.domain.entity.Category
import org.springframework.data.repository.CrudRepository
import java.util.Optional

interface CategoryRepository: CrudRepository<Category,Long> {
    override fun findAll(): List<Category>
    fun findCategoryById(categoryId: Long): Optional<Category>
}