package com.g3c1.aidboss.domain.seat.utils

import com.g3c1.aidboss.domain.seat.domain.entity.Seat
import com.g3c1.aidboss.domain.seat.presentaion.data.dto.CreateSeatDto
import com.g3c1.aidboss.domain.seat.presentaion.data.dto.SeatInfoDto
import com.g3c1.aidboss.domain.seat.presentaion.data.request.CreateSeatRequest
import com.g3c1.aidboss.domain.seat.presentaion.data.response.SeatInfoResponse
import com.g3c1.aidboss.domain.store.domain.entity.Store

interface SeatConverter {
    fun toDto(request: CreateSeatRequest): CreateSeatDto
    fun toDto(seat: Seat): SeatInfoDto
    fun toEntity(dto: CreateSeatDto, entity:Store): Seat
    fun toResponse(dto: List<SeatInfoDto>): List<SeatInfoResponse>
}