package com.g3c1.aidboss.domain.store.domain.repository

import com.g3c1.aidboss.domain.store.domain.entity.Store
import com.g3c1.aidboss.domain.user.domain.entity.User
import org.springframework.data.repository.CrudRepository

interface StoreRepository: CrudRepository<Store,Long> {
    fun findAllByUser(user: User): List<Store>
}