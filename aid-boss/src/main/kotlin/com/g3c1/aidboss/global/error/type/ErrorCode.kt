package com.g3c1.aidboss.global.error.type

enum class ErrorCode(val message:String, val status: Int) {
    SEAT_NOT_USED("SeatIsNotUsed",400),
    UNAUTHORIZED("Unauthorized",401),
    EXPIRED_TOKEN("Expired Token",401),
    INVALID_TOKEN( "Invalid Token",401),
    STORE_NOT_FOUND("StoreIsNotFound",404),
    SEAT_NOT_FOUND("SeatIsNotFound",404),
    USER_NOT_FOUND("UserIsNotFound",404),
    CATEGORY_NOT_FOUND("CategoryIsNotFound",404),
    INTERNET_SERVER_ERROR("InternetServerError",500)
}