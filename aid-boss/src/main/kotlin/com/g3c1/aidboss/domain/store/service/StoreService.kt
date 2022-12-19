package com.g3c1.aidboss.domain.store.service

import com.g3c1.aidboss.domain.store.presentation.data.dto.CreateStoreDto
import com.g3c1.aidboss.domain.store.presentation.data.dto.MyStoreDto

interface StoreService {
    fun createStore(dto: CreateStoreDto)
    fun findAllStoreById(): MyStoreDto
}