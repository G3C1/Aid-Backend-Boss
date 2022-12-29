package com.g3c1.aidboss.domain.store.service.impl

import com.g3c1.aidboss.domain.store.domain.repository.StoreRepository
import com.g3c1.aidboss.domain.store.presentation.data.dto.CreateStoreDto
import com.g3c1.aidboss.domain.store.presentation.data.dto.MyStoreDto
import com.g3c1.aidboss.domain.store.service.StoreService
import com.g3c1.aidboss.domain.store.utils.StoreConverter
import com.g3c1.aidboss.domain.user.utils.UserUtils
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class StoreServiceImpl(
    private val storeRepository: StoreRepository,
    private val storeConverter: StoreConverter,
    private val userUtils: UserUtils
): StoreService {
    @Transactional(rollbackFor = [Exception::class])
    override fun createStore(dto: CreateStoreDto) {
        val user = userUtils.getCurrentUser()
        storeConverter.toEntity(dto,user)
            .let { storeRepository.save(it) }
    }

    override fun findAllStoreById(): MyStoreDto {
        val user = userUtils.getCurrentUser()
        val storeList = storeRepository.findAllByUser(user)
        return storeConverter.toDto(user.name,storeList)
    }
}