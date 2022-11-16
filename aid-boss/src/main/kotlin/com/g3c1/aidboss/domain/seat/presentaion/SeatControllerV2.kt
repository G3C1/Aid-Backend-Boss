package com.g3c1.aidboss.domain.seat.presentaion

import com.g3c1.aidboss.domain.seat.presentaion.data.request.CreateSeatRequest
import com.g3c1.aidboss.domain.seat.service.SeatServiceV2
import com.g3c1.aidboss.domain.seat.utils.SeatConverter
import org.jetbrains.annotations.NotNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("api/v2/seat")
class SeatControllerV2(
    private val seatConverter: SeatConverter,
    private val seatServiceV2: SeatServiceV2
) {
    @PostMapping("{serialNumber}")
    fun createSeat(@RequestBody @Valid createSeatRequest: CreateSeatRequest, @NotNull @PathVariable serialNumber: Long): ResponseEntity<Void> =
        seatConverter.toDto(createSeatRequest)
            .let { seatServiceV2.createSeat(it,serialNumber) }
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }
}