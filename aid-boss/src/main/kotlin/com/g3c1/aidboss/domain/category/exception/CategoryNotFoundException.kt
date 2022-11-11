package com.g3c1.aidboss.domain.category.exception

import com.g3c1.aidboss.global.error.type.ErrorCode
import com.g3c1.aidboss.global.error.exception.BasicException

class CategoryNotFoundException: BasicException(ErrorCode.CATEGORY_NOT_FOUND)