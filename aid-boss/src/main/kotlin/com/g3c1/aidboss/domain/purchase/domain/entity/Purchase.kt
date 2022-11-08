package com.g3c1.aidboss.domain.purchase.domain.entity

import com.g3c1.temiuser.global.entity.BaseTimeIdEntity
import javax.persistence.Column
import javax.persistence.Entity

@Entity
data class Purchase(
    @Column(nullable = false)
    val seatNumber: Long,
    @Column(nullable = false)
    val severalPeople: Long,
    @Column(nullable = false)
    var enabled: Boolean,
):BaseTimeIdEntity()
