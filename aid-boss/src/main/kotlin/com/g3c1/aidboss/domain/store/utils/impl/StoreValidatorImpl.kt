package com.g3c1.aidboss.domain.store.utils.impl

import com.g3c1.aidboss.domain.store.domain.repository.StoreRepository
import com.g3c1.aidboss.domain.store.utils.StoreValidator

class StoreValidatorImpl(
    private val storeRepository: StoreRepository
): StoreValidator{
    override fun validateStore(serialNumber: Long) {
        when(storeRepository.existsById(serialNumber)){
            true -> {}//ToDo - 이미 존재하는 가게라고 예외처리하기}
            false -> {return}
        }
    }
}