package com.g3c1.aidboss.domain.store.utils.impl

import com.g3c1.aidboss.domain.store.domain.repository.StoreRepository
import com.g3c1.aidboss.domain.store.exception.StoreAlreadyExistException
import com.g3c1.aidboss.domain.store.utils.StoreValidator
import org.springframework.stereotype.Component

@Component
class StoreValidatorImpl(
    private val storeRepository: StoreRepository
): StoreValidator{
    override fun validateStore(serialNumber: Long) {
        when(storeRepository.existsById(serialNumber)){
            true -> {throw StoreAlreadyExistException()}
            false -> {return}
        }
    }
}