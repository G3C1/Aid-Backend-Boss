package com.g3c1.aidboss.domain.store.exception

import com.g3c1.aidboss.global.error.ErrorCode
import com.g3c1.aidboss.global.error.exception.BasicException

class StoreNotFoundException: BasicException(ErrorCode.STORE_NOT_FOUND)