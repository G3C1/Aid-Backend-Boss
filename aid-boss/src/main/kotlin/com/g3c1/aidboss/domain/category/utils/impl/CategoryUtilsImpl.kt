package com.g3c1.aidboss.domain.category.utils.impl

import com.g3c1.aidboss.domain.category.domain.entity.Category
import com.g3c1.aidboss.domain.category.domain.repository.CategoryRepository
import com.g3c1.aidboss.domain.category.exception.CategoryNotFoundException
import com.g3c1.aidboss.domain.category.utils.CategoryUtils
import com.g3c1.aidboss.domain.store.domain.entity.Store
import org.springframework.stereotype.Component

@Component
class CategoryUtilsImpl(
    private val categoryRepository: CategoryRepository
):CategoryUtils {
    override fun findAllCategory(): List<Category> = categoryRepository.findAll()
    override fun findById(categoryId: Long): Category = categoryRepository.findCategoryById(categoryId).orElseThrow { CategoryNotFoundException() }
    override fun findAllCategoryByStore(store: Store): List<Category> = categoryRepository.findAllByStore(store)
}