package com.g3c1.aidboss.domain.seat.utils

import com.g3c1.aidboss.domain.seat.domain.entity.Seat

interface SeatValidator {
    fun checkIsNotUsed(seat: Seat): Seat
}