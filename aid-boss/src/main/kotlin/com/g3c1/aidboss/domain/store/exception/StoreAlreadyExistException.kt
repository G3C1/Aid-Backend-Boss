package com.g3c1.aidboss.domain.store.exception

import com.g3c1.aidboss.global.error.exception.BasicException
import com.g3c1.aidboss.global.error.type.ErrorCode

class StoreAlreadyExistException: BasicException(ErrorCode.STORE_ALREADY_EXIST)