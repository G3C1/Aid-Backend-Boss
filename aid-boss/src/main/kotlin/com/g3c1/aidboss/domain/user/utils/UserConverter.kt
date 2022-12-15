package com.g3c1.aidboss.domain.user.utils

import com.g3c1.aidboss.domain.user.domain.entity.User
import com.g3c1.aidboss.domain.user.presentation.data.dto.LoginDto
import com.g3c1.aidboss.domain.user.presentation.data.dto.RegisterDto
import com.g3c1.aidboss.domain.user.presentation.data.dto.TokenDto
import com.g3c1.aidboss.domain.user.presentation.data.request.LoginRequest
import com.g3c1.aidboss.domain.user.presentation.data.request.RegisterRequest
import com.g3c1.aidboss.domain.user.presentation.data.response.TokenResponse

interface UserConverter {
    fun toDto(request: RegisterRequest): RegisterDto
    fun toDto(request: LoginRequest): LoginDto
    fun toResponse(dto: TokenDto): TokenResponse
    fun toEntity(dto: RegisterDto, encodedPassword:String): User
}