package com.g3c1.aidboss.domain.store.utils.impl

import com.g3c1.aidboss.domain.store.domain.entity.Store
import com.g3c1.aidboss.domain.store.presentation.data.dto.CreateStoreDto
import com.g3c1.aidboss.domain.store.presentation.data.dto.MyStoreDto
import com.g3c1.aidboss.domain.store.presentation.data.request.CreateStoreRequest
import com.g3c1.aidboss.domain.store.presentation.data.response.MyStoreResponse
import com.g3c1.aidboss.domain.store.utils.StoreConverter
import com.g3c1.aidboss.domain.user.domain.entity.User
import org.springframework.stereotype.Component

@Component
class StoreConverterImpl: StoreConverter {
    override fun toDto(createStoreRequest: CreateStoreRequest): CreateStoreDto =
        CreateStoreDto(createStoreRequest.serialNumber,createStoreRequest.name,createStoreRequest.description,createStoreRequest.img)
    override fun toDto(userName: String, storeList: List<Store>): MyStoreDto =
        MyStoreDto(userName,storeList.map { MyStoreDto.StoreInfoDto(it.name,it.img,it.description) })
    override fun toResponse(dto: MyStoreDto): MyStoreResponse =
        MyStoreResponse(dto.userName,dto.StoreList.map { MyStoreResponse.StoreInfoResponse(it.name,it.img,it.description)})
    override fun toEntity(dto: CreateStoreDto, user: User): Store =
        Store(dto.serialNumber,dto.name,dto.description,dto.img,user)
}