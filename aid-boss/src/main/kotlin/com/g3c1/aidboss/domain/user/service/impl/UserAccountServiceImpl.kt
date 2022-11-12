package com.g3c1.aidboss.domain.user.service.impl

import com.g3c1.aidboss.domain.user.domain.repository.UserRepository
import com.g3c1.aidboss.domain.user.presentation.data.dto.RegisterDto
import com.g3c1.aidboss.domain.user.service.UserAccountService
import com.g3c1.aidboss.domain.user.utils.UserConverter
import com.g3c1.aidboss.domain.user.utils.UserValidator
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserAccountServiceImpl(
    private val userRepository: UserRepository,
    private val userConverter: UserConverter,
    private val userValidator: UserValidator,
    private val passwordEncoder: PasswordEncoder
): UserAccountService {
    override fun register(registerDto: RegisterDto) {
        userValidator.validateUserId(registerDto.id)
            .let { userConverter.toEntity(registerDto,passwordEncoder.encode(registerDto.password))}
            .let { userRepository.save(it) }
    }
}