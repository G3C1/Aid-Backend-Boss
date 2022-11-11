package com.g3c1.aidboss.global.security.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.g3c1.aidboss.global.error.type.ErrorCode
import com.g3c1.aidboss.global.error.exception.BasicException
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExceptionFilter(
    private val objectMapper: ObjectMapper
):OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        try{
            filterChain.doFilter(request,response)
        }catch (e:BasicException){
            sendError(response,e.errorCode)
        }catch (e: Exception){
            logger.error(e)
            sendError(response, ErrorCode.INTERNET_SERVER_ERROR)
        }
    }
    private fun sendError(response: HttpServletResponse,errorCode: ErrorCode){
        val errorResponse = errorCode.status
        val responseString = objectMapper.writeValueAsString(errorResponse)

        response.status = errorCode.status
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(responseString)
    }
}