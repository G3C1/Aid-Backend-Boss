package com.g3c1.aidboss.domain.seat.service.impl

import com.g3c1.aidboss.domain.seat.presentaion.data.dto.CreateSeatDto
import com.g3c1.aidboss.domain.seat.service.SeatService
import com.g3c1.aidboss.domain.seat.utils.SeatConverter
import com.g3c1.aidboss.domain.seat.utils.SeatUtils
import com.g3c1.aidboss.domain.seat.utils.SeatValidator
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SeatServiceImpl(
    private val seatUtils: SeatUtils,
    private val seatValidator: SeatValidator,
    private val seatConverter: SeatConverter
): SeatService {
    @Transactional(rollbackFor = [Exception::class])
    override fun createSeat(createSeatDto: CreateSeatDto) {
        seatConverter.toEntity(createSeatDto)
            .let { seatUtils.save(it)}
    }

    @Transactional(rollbackFor = [Exception::class])
    override fun patchDisableUsingSeat(seatId: Long) =
        seatUtils.findSeatById(seatId)
            .let {seatValidator.checkIsNotUsed(it)}
            .let { it.enabled = true }
}