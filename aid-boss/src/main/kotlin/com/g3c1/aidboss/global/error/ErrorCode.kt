package com.g3c1.aidboss.global.error

enum class ErrorCode(val message:String, val status: Int) {
    CATEGORY_NOT_FOUND("카테고리를 찾을 수 없습니다.",404)
}