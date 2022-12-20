package com.g3c1.aidboss.global.error.type

enum class ErrorCode(val message:String, val status: Int) {
    SEAT_NOT_USED("SeatIsNotUsed",400),
    PASSWORD_MIS_MATCH("PasswordMisMatch",400),
    UNAUTHORIZED("Unauthorized",401),
    EXPIRED_TOKEN("Expired Token",401),
    INVALID_TOKEN( "Invalid Token",401),
    STORE_NOT_FOUND("StoreIsNotFound",404),
    SEAT_NOT_FOUND("SeatIsNotFound",404),
    FOOD_NOT_FOUND("Food Not Found",404),
    USER_NOT_FOUND("UserIsNotFound",404),
    CATEGORY_NOT_FOUND("CategoryIsNotFound",404),
    USER_ALREADY_EXIST("User Already Exist",409),
    STORE_ALREADY_EXIST("Store Already Exist",409),
    INTERNET_SERVER_ERROR("InternetServerError",500)
}