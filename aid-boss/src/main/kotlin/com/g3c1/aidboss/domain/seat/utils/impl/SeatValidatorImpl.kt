package com.g3c1.aidboss.domain.seat.utils.impl

import com.g3c1.aidboss.domain.seat.domain.entity.Seat
import com.g3c1.aidboss.domain.seat.exception.SeatNotUsedException
import com.g3c1.aidboss.domain.seat.utils.SeatValidator
import org.springframework.stereotype.Component

@Component
class SeatValidatorImpl: SeatValidator {
    override fun checkIsNotUsed(seat: Seat): Seat {
        return when {
            !seat.enabled -> seat
            else -> throw SeatNotUsedException()
        }
    }
}