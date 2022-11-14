package com.g3c1.aidboss.domain.store.utils.impl

import com.g3c1.aidboss.domain.store.domain.entity.Store
import com.g3c1.aidboss.domain.store.presentation.data.dto.CreateStoreDto
import com.g3c1.aidboss.domain.store.presentation.data.request.CreateStoreRequest
import com.g3c1.aidboss.domain.store.utils.StoreConverter
import com.g3c1.aidboss.domain.user.domain.entity.User
import org.springframework.stereotype.Component

@Component
class StoreConverterImpl: StoreConverter {
    override fun toDto(createStoreRequest: CreateStoreRequest): CreateStoreDto =
        CreateStoreDto(createStoreRequest.serialNumber,createStoreRequest.name,createStoreRequest.description,createStoreRequest.img)

    override fun toEntity(dto: CreateStoreDto, user: User): Store =
        Store(dto.serialNumber,dto.name,dto.description,dto.img,user)


}