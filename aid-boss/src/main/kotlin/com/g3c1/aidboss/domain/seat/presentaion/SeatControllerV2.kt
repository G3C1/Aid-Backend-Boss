package com.g3c1.aidboss.domain.seat.presentaion

import com.g3c1.aidboss.domain.seat.presentaion.data.request.CreateSeatRequest
import com.g3c1.aidboss.domain.seat.presentaion.data.response.SeatInfoResponse
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
    @GetMapping("{serial_number}")
    fun findSeatByStore(@NotNull @PathVariable("serial_number") serialNumber: Long): ResponseEntity<List<SeatInfoResponse>> =
        seatServiceV2.findSeatByStoreId(serialNumber)
            .let { seatConverter.toResponse(it) }
            .let { ResponseEntity.ok().body(it) }


    @PostMapping("{serial_number}")
    fun createSeat(@Valid @RequestBody createSeatRequest: CreateSeatRequest, @NotNull @PathVariable("serial_number") serialNumber: Long): ResponseEntity<Void> =
        seatConverter.toDto(createSeatRequest)
            .let { seatServiceV2.createSeat(it,serialNumber) }
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }
}