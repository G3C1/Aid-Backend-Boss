package com.g3c1.aidboss.domain.category.service.impl

import com.g3c1.aidboss.domain.category.domain.repository.CategoryRepository
import com.g3c1.aidboss.domain.category.presentation.data.dto.CategoryDto
import com.g3c1.aidboss.domain.category.service.CategoryService
import com.g3c1.aidboss.domain.category.utils.CategoryConverter
import com.g3c1.aidboss.domain.store.domain.entity.Store
import com.g3c1.aidboss.domain.store.utils.StoreUtils
import com.g3c1.aidboss.domain.user.domain.entity.User
import org.springframework.data.jpa.repository.Lock
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.LockModeType

@Service
class CategoryServiceImpl(
    private val categoryRepository: CategoryRepository,
    private val storeUtils: StoreUtils,
    private val categoryConverter: CategoryConverter
): CategoryService {
    @Transactional(rollbackFor = [Exception::class])
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    override fun createCategory(dto: CategoryDto) {
        categoryConverter.toEntity(
            dto,
            storeUtils.findStoreBySerialNumber(0)
        )
            .let { categoryRepository.save(it) }
    }
}