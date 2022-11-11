package com.g3c1.aidboss.domain.user.exception

import com.g3c1.aidboss.global.error.type.ErrorCode
import com.g3c1.aidboss.global.error.exception.BasicException

class UserNotFoundException: BasicException(ErrorCode.USER_NOT_FOUND)