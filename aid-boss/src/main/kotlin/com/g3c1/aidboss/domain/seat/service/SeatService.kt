package com.g3c1.aidboss.domain.seat.service

import com.g3c1.aidboss.domain.seat.presentaion.data.dto.CreateSeatDto

interface SeatService {
    fun createSeat(createSeatDto: CreateSeatDto)
    fun patchDisableUsingSeat(seatId: Long)
}