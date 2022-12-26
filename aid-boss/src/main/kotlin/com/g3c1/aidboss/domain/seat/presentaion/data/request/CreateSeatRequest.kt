package com.g3c1.aidboss.domain.seat.presentaion.data.request

import org.jetbrains.annotations.NotNull

data class CreateSeatRequest (
    @field:NotNull
    val seatNumber: Long,
    @field:NotNull
    val severalPeople: Long,
    @field: NotNull
    val x: Float,
    @field: NotNull
    val y: Float
)