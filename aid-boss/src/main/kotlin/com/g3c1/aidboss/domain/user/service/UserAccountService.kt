package com.g3c1.aidboss.domain.user.service

import com.g3c1.aidboss.domain.user.presentation.data.dto.LoginDto
import com.g3c1.aidboss.domain.user.presentation.data.dto.RegisterDto
import com.g3c1.aidboss.domain.user.presentation.data.dto.TokenDto

interface UserAccountService {
    fun register(dto: RegisterDto)
    fun login(dto: LoginDto): TokenDto
    fun refresh(refreshToken: String): TokenDto
    fun withdrawal()
}