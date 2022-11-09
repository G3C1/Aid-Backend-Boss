package com.g3c1.aidboss.global.error.exception

import com.g3c1.aidboss.global.error.ErrorCode

open class BasicException(
    val errorCode: ErrorCode
): RuntimeException()