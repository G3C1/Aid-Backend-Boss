package com.g3c1.aidboss.domain.seat.service

import com.g3c1.aidboss.domain.seat.presentaion.data.dto.CreateSeatDto
import com.g3c1.aidboss.domain.seat.presentaion.data.dto.SeatInfoDto

interface SeatServiceV2 {
    fun createSeat(dto: CreateSeatDto,serialNumber: Long)
    fun findSeatByStoreId(serialNumber: Long): List<SeatInfoDto>
}