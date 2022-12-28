package com.g3c1.aidboss.domain.image.Exception

import com.g3c1.aidboss.global.error.exception.BasicException
import com.g3c1.aidboss.global.error.type.ErrorCode

class FailUploadImageException: BasicException(ErrorCode.INTERNET_SERVER_ERROR) {
}