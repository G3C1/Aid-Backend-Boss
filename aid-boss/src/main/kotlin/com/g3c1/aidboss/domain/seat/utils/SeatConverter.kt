package com.g3c1.aidboss.domain.seat.utils

import com.g3c1.aidboss.domain.seat.domain.entity.Seat
import com.g3c1.aidboss.domain.seat.presentaion.data.dto.CreateSeatDto
import com.g3c1.aidboss.domain.seat.presentaion.data.request.CreateSeatRequest

interface SeatConverter {
    fun toDto(createSeatRequest: CreateSeatRequest): CreateSeatDto
    fun toEntity(createSeatDto: CreateSeatDto): Seat
}