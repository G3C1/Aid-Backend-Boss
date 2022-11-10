package com.g3c1.aidboss.global.error

enum class ErrorCode(val message:String, val status: Int) {
    SEAT_NOT_USED("사용 중이지않는 좌석입니다.",400),
    STORE_NOT_FOUND("가게를 찾을 수 없습니다.",404),
    SEAT_NOT_FOUND("좌석을 찾을 수 없습니다.",404),
    CATEGORY_NOT_FOUND("카테고리를 찾을 수 없습니다.",404)
}