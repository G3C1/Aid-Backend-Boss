package com.g3c1.aidboss.domain.seat.utils.impl

import com.g3c1.aidboss.domain.seat.domain.entity.Seat
import com.g3c1.aidboss.domain.seat.presentaion.data.dto.CreateSeatDto
import com.g3c1.aidboss.domain.seat.presentaion.data.dto.SeatInfoDto
import com.g3c1.aidboss.domain.seat.presentaion.data.request.CreateSeatRequest
import com.g3c1.aidboss.domain.seat.presentaion.data.response.SeatInfoResponse
import com.g3c1.aidboss.domain.seat.utils.SeatConverter
import com.g3c1.aidboss.domain.store.domain.entity.Store
import org.springframework.stereotype.Component

@Component
class SeatConverterImpl:SeatConverter {
    override fun toDto(request: CreateSeatRequest): CreateSeatDto =
        CreateSeatDto(request.seatNumber, request.severalPeople)

    override fun toDto(seat: Seat): SeatInfoDto =
        SeatInfoDto(seat.id, seat.seatNumber, seat.severalPeople, seat.enabled)


    override fun toEntity(dto: CreateSeatDto, entity: Store): Seat =
        Seat(dto.seatNumber, dto.severalPeople,true, entity)

    override fun toResponse(dto: List<SeatInfoDto>): List<SeatInfoResponse> =
        dto.toList().map { SeatInfoResponse(it.idx, it.seatNumber, it.severalPeople, it.enabled) }

}