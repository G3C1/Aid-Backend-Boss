package com.g3c1.aidboss.domain.food.exception

import com.g3c1.aidboss.global.error.exception.BasicException
import com.g3c1.aidboss.global.error.type.ErrorCode

class FoodNotFoundException:BasicException(ErrorCode.FOOD_NOT_FOUND)