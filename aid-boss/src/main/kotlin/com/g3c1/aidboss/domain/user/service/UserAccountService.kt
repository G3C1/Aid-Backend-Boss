package com.g3c1.aidboss.domain.user.service

import com.g3c1.aidboss.domain.user.presentation.data.dto.RegisterDto

interface UserAccountService {
    fun register(registerDto: RegisterDto)
}