package com.g3c1.aidboss.domain.seat.presentaion.data.response

data class SeatInfoResponse(
    val id: Long,
    val seatNumber: Long,
    val severalPeople: Long,
    val x: Float,
    val y: Float,
    val enabled: Boolean
)
