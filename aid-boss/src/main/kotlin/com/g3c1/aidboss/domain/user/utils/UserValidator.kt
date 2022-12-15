package com.g3c1.aidboss.domain.user.utils

import com.g3c1.aidboss.domain.user.presentation.data.dto.LoginDto

interface UserValidator {
    fun validateUserId(userId: String)
    fun validatePassword(dto: LoginDto)
}