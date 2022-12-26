package com.g3c1.aidboss.domain.seat.domain.entity

import com.g3c1.aidboss.domain.store.domain.entity.Store
import com.g3c1.temiuser.global.entity.BaseIdEntity
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
data class Seat(
    @Column(nullable = false)
    val seatNumber: Long,
    @Column(nullable = false)
    val severalPeople: Long,
    @Column(nullable = false)
    var enabled: Boolean,
    @Column(nullable = false, name = "location_x")
    val locationX: Float,
    @Column(nullable = false, name = "location_y")
    val locationY: Float,
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "store_id")
    val store:Store
):BaseIdEntity()