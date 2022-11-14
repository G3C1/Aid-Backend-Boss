package com.g3c1.aidboss.domain.store.service

import com.g3c1.aidboss.domain.store.presentation.data.dto.CreateStoreDto

interface StoreService {
    fun createStore(createStoreDto: CreateStoreDto)
}