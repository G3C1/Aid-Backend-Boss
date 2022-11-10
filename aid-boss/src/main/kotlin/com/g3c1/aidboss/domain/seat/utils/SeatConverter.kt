package com.g3c1.aidboss.domain.seat.utils

import com.g3c1.aidboss.domain.seat.domain.entity.Seat
import com.g3c1.aidboss.domain.seat.presentaion.data.dto.CreateSeatDto
import com.g3c1.aidboss.domain.seat.presentaion.data.request.CreateSeatRequest
import com.g3c1.aidboss.domain.store.domain.entity.Store

interface SeatConverter {
    fun toDto(createSeatRequest: CreateSeatRequest): CreateSeatDto
    fun toEntity(createSeatDto: CreateSeatDto,store:Store): Seat
}