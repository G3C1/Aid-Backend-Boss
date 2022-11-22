package com.g3c1.aidboss.domain.store.utils

import com.g3c1.aidboss.domain.store.domain.entity.Store

interface StoreUtils {
    fun findStoreBySerialNumber(serialNumber: Long): Store
}