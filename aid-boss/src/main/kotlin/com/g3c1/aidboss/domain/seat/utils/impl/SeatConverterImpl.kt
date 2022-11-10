package com.g3c1.aidboss.domain.seat.utils.impl

import com.g3c1.aidboss.domain.seat.domain.entity.Seat
import com.g3c1.aidboss.domain.seat.presentaion.data.dto.CreateSeatDto
import com.g3c1.aidboss.domain.seat.presentaion.data.request.CreateSeatRequest
import com.g3c1.aidboss.domain.seat.utils.SeatConverter
import com.g3c1.aidboss.domain.store.domain.entity.Store
import org.springframework.stereotype.Component

@Component
class SeatConverterImpl:SeatConverter {
    override fun toDto(createSeatRequest: CreateSeatRequest): CreateSeatDto =
        CreateSeatDto(createSeatRequest.seatNumber,createSeatRequest.severalPeople)

    override fun toEntity(createSeatDto: CreateSeatDto,store:Store): Seat =
        Seat(createSeatDto.seatNumber,createSeatDto.severalPeople,true,store)

}