package com.g3c1.aidboss.domain.user.utils

import com.g3c1.aidboss.domain.user.domain.entity.User
import com.g3c1.aidboss.domain.user.presentation.data.dto.RegisterDto
import com.g3c1.aidboss.domain.user.presentation.data.request.RegisterRequest

interface UserConverter {
    fun toDto(registerRequest: RegisterRequest): RegisterDto
    fun toEntity(registerDto: RegisterDto,encodedPassword:String): User
}