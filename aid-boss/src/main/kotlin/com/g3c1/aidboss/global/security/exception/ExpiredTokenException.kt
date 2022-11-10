package com.g3c1.aidboss.global.security.exception

import com.g3c1.aidboss.global.error.ErrorCode
import com.g3c1.aidboss.global.error.exception.BasicException

class ExpiredTokenException: BasicException(ErrorCode.EXPIRED_TOKEN)