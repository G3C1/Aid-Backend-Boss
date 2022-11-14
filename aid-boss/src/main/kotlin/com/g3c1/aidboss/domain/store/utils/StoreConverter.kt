package com.g3c1.aidboss.domain.store.utils

import com.g3c1.aidboss.domain.store.domain.entity.Store
import com.g3c1.aidboss.domain.store.presentation.data.dto.CreateStoreDto
import com.g3c1.aidboss.domain.store.presentation.data.request.CreateStoreRequest
import com.g3c1.aidboss.domain.user.domain.entity.User

interface StoreConverter {
    fun toDto(createStoreRequest: CreateStoreRequest): CreateStoreDto
    fun toEntity(dto: CreateStoreDto,user: User): Store
}