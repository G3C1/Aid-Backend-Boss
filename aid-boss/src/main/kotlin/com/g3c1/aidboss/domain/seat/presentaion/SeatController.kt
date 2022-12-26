package com.g3c1.aidboss.domain.seat.presentaion

import com.g3c1.aidboss.domain.seat.presentaion.data.request.CreateSeatRequest
import com.g3c1.aidboss.domain.seat.service.SeatService
import com.g3c1.aidboss.domain.seat.utils.SeatConverter
import org.jetbrains.annotations.NotNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("api/v1/seat")
class SeatController(
    private val seatService: SeatService,
    private val seatConverter: SeatConverter
) {
    @PostMapping
    fun createSeat(@Valid @RequestBody createSeatRequest: CreateSeatRequest):ResponseEntity<Void> =
        seatConverter.toDto(createSeatRequest)
            .let { seatService.createSeat(it) }
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @PatchMapping("/cancel/{seat_id}")
    fun patchDisableUsingSeat(@NotNull @PathVariable("seat_id") seatId: Long): ResponseEntity<Void> =
        seatService.patchDisableUsingSeat(seatId)
            .let { ResponseEntity.status(HttpStatus.NO_CONTENT).build()}
}