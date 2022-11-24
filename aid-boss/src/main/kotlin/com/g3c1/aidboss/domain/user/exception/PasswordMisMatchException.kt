package com.g3c1.aidboss.domain.user.exception

import com.g3c1.aidboss.global.error.exception.BasicException
import com.g3c1.aidboss.global.error.type.ErrorCode

class PasswordMisMatchException: BasicException(ErrorCode.PASSWORD_MIS_MATCH)