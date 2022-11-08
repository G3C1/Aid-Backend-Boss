package com.g3c1.aidboss.domain.purchase.domain.repository

import com.g3c1.aidboss.domain.purchase.domain.entity.Purchase
import org.springframework.data.repository.CrudRepository

interface PurchaseRepository: CrudRepository<Purchase,Long> {
}