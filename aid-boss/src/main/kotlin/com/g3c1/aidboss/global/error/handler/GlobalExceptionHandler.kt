package com.g3c1.aidboss.global.error.handler

import com.g3c1.aidboss.global.error.type.ErrorCode
import com.g3c1.aidboss.global.error.response.ErrorResponse
import com.g3c1.aidboss.global.error.exception.BasicException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(BasicException::class)
    fun globalExceptionHandler(e:BasicException) : ResponseEntity<ErrorResponse?> {
        val errorCode: ErrorCode = e.errorCode
        return ResponseEntity(
            ErrorResponse(status = errorCode.status, message = errorCode.message),
            HttpStatus.valueOf(errorCode.status)
        )
    }
}