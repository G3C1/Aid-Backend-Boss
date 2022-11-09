package com.g3c1.aidboss.domain.seat.exception

import com.g3c1.aidboss.global.error.ErrorCode
import com.g3c1.aidboss.global.error.exception.BasicException

class SeatNotFoundException:BasicException(ErrorCode.SEAT_NOT_FOUND) {
}