package com.g3c1.aidboss.domain.purchase.domain.entity

import com.g3c1.aidboss.domain.food.domain.entity.Food
import com.g3c1.aidboss.domain.seat.domain.entity.Seat
import com.g3c1.temiuser.global.entity.BaseTimeIdEntity
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
data class Purchase(
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(nullable = true)
    val food: Food,
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(nullable = true)
    val seat: Seat,
    val foodCount: Long
):BaseTimeIdEntity()
