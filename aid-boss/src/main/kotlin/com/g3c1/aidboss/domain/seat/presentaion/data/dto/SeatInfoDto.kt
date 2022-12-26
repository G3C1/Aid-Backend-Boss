package com.g3c1.aidboss.domain.seat.presentaion.data.dto

data class SeatInfoDto (
    val idx: Long,
    val seatNumber: Long,
    val severalPeople: Long,
    val x: Float,
    val y: Float,
    val enabled: Boolean
)