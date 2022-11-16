package com.g3c1.aidboss.domain.category.service.impl

import com.g3c1.aidboss.domain.category.domain.repository.CategoryRepository
import com.g3c1.aidboss.domain.category.presentation.data.dto.CategoryDto
import com.g3c1.aidboss.domain.category.service.CategoryServiceV2
import com.g3c1.aidboss.domain.category.utils.CategoryConverter
import com.g3c1.aidboss.domain.store.utils.StoreUtlis
import org.springframework.data.jpa.repository.Lock
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.LockModeType

@Service
class CategoryServiceV2Impl(
    private val categoryConverter: CategoryConverter,
    private val categoryRepository: CategoryRepository,
    private val storeUtils: StoreUtlis
): CategoryServiceV2 {
    @Transactional(rollbackFor = [Exception::class])
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    override fun createCategory(categoryDto: CategoryDto, serialNumber: Long) {
        categoryConverter.toEntity(categoryDto,storeUtils.findStoreBySerialNumber(serialNumber))
            .let { categoryRepository.save(it) }
    }
}