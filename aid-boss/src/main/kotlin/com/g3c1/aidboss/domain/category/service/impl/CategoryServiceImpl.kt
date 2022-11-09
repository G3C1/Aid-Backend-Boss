package com.g3c1.aidboss.domain.category.service.impl

import com.g3c1.aidboss.domain.category.domain.repository.CategoryRepository
import com.g3c1.aidboss.domain.category.presentation.data.dto.CategoryDto
import com.g3c1.aidboss.domain.category.service.CategoryService
import com.g3c1.aidboss.domain.category.utils.CategoryConverter
import org.springframework.data.jpa.repository.Lock
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.LockModeType

@Service
class CategoryServiceImpl(
    private val categoryRepository: CategoryRepository,
    private val categoryConverter: CategoryConverter
): CategoryService {
    @Transactional(rollbackFor = [Exception::class])
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    override fun createCategory(categoryDto: CategoryDto) {
        categoryConverter.toEntity(categoryDto)
            .let { categoryRepository.saveAll(it) }
    }
}