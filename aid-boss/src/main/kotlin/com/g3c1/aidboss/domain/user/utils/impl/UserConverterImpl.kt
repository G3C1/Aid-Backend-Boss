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
    override fun toDto(registerRequest: RegisterRequest): RegisterDto =
        RegisterDto(registerRequest.id,registerRequest.password,registerRequest.name)

    override fun toDto(loginRequest: LoginRequest): LoginDto =
       LoginDto(loginRequest.id,loginRequest.password)
    override fun toResponse(tokenDto: TokenDto): TokenResponse =
        TokenResponse(tokenDto.accessToken,tokenDto.refreshToken,tokenDto.expiredAt)

    override fun toEntity(registerDto: RegisterDto, encodedPassword: String): User =
        User(registerDto.id,registerDto.name,encodedPassword)
}