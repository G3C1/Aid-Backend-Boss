package com.g3c1.aidboss.domain.seat.service

import com.g3c1.aidboss.domain.seat.presentaion.data.dto.CreateSeatDto

interface SeatServiceV2 {
    fun createSeat(createSeatDto: CreateSeatDto,serialNumber: Long)
}