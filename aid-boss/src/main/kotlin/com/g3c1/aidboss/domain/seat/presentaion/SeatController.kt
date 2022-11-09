package com.g3c1.aidboss.domain.seat.presentaion

import com.g3c1.aidboss.domain.seat.service.SeatService
import org.jetbrains.annotations.NotNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/seat")
class SeatController(
    private val seatService: SeatService
) {
    @PatchMapping("/cancel/{seatId}")
    fun patchDisableUsingSeat(@NotNull @PathVariable seatId: Long): ResponseEntity<Void> =
        seatService.patchDisableUsingSeat(seatId)
            .let { ResponseEntity.status(HttpStatus.NO_CONTENT).build()}
}