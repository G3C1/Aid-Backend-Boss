package com.g3c1.aidboss.global.security.exception

import com.fasterxml.jackson.databind.ObjectMapper
import com.g3c1.aidboss.global.error.type.ErrorCode
import com.g3c1.aidboss.global.error.response.ErrorResponse
import org.springframework.http.MediaType
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class CustomAuthenticationEntryPoint(
    private val objectMapper: ObjectMapper
): AuthenticationEntryPoint {
    override fun commence(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authException: AuthenticationException?,
    ) {
        val errorCode: ErrorCode = ErrorCode.UNAUTHORIZED
        val responseString:String = objectMapper.writeValueAsString(
            ErrorResponse(errorCode.message,errorCode.status)
        )
        response?.status = errorCode.status
        response?.contentType = MediaType.APPLICATION_JSON_VALUE
        response?.writer?.write(responseString);
    }
}