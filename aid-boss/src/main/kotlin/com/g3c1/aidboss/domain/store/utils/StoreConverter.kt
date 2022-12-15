package com.g3c1.aidboss.domain.store.utils

import com.g3c1.aidboss.domain.store.domain.entity.Store
import com.g3c1.aidboss.domain.store.presentation.data.dto.CreateStoreDto
import com.g3c1.aidboss.domain.store.presentation.data.dto.MyStoreDto
import com.g3c1.aidboss.domain.store.presentation.data.request.CreateStoreRequest
import com.g3c1.aidboss.domain.store.presentation.data.response.MyStoreResponse
import com.g3c1.aidboss.domain.user.domain.entity.User

interface StoreConverter {
    fun toDto(request: CreateStoreRequest): CreateStoreDto
    fun toDto(userName: String,storeList:List<Store>):MyStoreDto
    fun toResponse(dto: MyStoreDto): MyStoreResponse
    fun toEntity(dto: CreateStoreDto,user: User): Store
}