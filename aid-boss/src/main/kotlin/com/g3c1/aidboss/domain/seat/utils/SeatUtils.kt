package com.g3c1.aidboss.domain.seat.utils

import com.g3c1.aidboss.domain.seat.domain.entity.Seat

interface SeatUtils {
    fun findSeatById(seatId: Long): Seat
    fun save(seat: Seat)
    fun findSeatByStoreId(serialNumber: Long): List<Seat>
}