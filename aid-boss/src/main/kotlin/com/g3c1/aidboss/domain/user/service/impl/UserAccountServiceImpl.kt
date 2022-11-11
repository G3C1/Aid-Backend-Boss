package com.g3c1.aidboss.domain.user.service.impl

import com.g3c1.aidboss.domain.user.domain.repository.UserRepository
import com.g3c1.aidboss.domain.user.presentation.data.dto.RegisterDto
import com.g3c1.aidboss.domain.user.service.UserAccountService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserAccountServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: BCryptPasswordEncoder
): UserAccountService {
    override fun register(registerDto: RegisterDto) {
    }
}