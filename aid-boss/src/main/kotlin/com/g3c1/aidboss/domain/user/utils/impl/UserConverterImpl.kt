package com.g3c1.aidboss.domain.user.utils.impl

import com.g3c1.aidboss.domain.user.domain.entity.User
import com.g3c1.aidboss.domain.user.presentation.data.dto.LoginDto
import com.g3c1.aidboss.domain.user.presentation.data.dto.RegisterDto
import com.g3c1.aidboss.domain.user.presentation.data.dto.TokenDto
import com.g3c1.aidboss.domain.user.presentation.data.request.LoginRequest
import com.g3c1.aidboss.domain.user.presentation.data.request.RegisterRequest
import com.g3c1.aidboss.domain.user.presentation.data.response.TokenResponse
import com.g3c1.aidboss.domain.user.utils.UserConverter
import org.springframework.stereotype.Component

@Component
class UserConverterImpl: UserConverter {
    override fun toDto(request: RegisterRequest): RegisterDto =
        RegisterDto(request.id, request.password, request.name)

    override fun toDto(request: LoginRequest): LoginDto =
       LoginDto(request.id, request.password)
    override fun toResponse(dto: TokenDto): TokenResponse =
        TokenResponse(dto.accessToken, dto.refreshToken, dto.expiredAt)

    override fun toEntity(dto: RegisterDto, encodedPassword: String): User =
        User(dto.id, encodedPassword, dto.name)
}