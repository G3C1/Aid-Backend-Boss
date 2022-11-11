package com.g3c1.aidboss.domain.seat.exception

import com.g3c1.aidboss.global.error.type.ErrorCode
import com.g3c1.aidboss.global.error.exception.BasicException

class SeatNotUsedException: BasicException(ErrorCode.SEAT_NOT_USED)