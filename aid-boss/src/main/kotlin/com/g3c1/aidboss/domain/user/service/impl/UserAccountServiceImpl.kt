package com.g3c1.aidboss.domain.user.service.impl

import com.g3c1.aidboss.domain.user.domain.entity.RefreshToken
import com.g3c1.aidboss.domain.user.domain.repository.RefreshTokenRepository
import com.g3c1.aidboss.domain.user.domain.repository.UserRepository
import com.g3c1.aidboss.domain.user.exception.UserNotFoundException
import com.g3c1.aidboss.domain.user.presentation.data.dto.LoginDto
import com.g3c1.aidboss.domain.user.presentation.data.dto.RegisterDto
import com.g3c1.aidboss.domain.user.presentation.data.dto.TokenDto
import com.g3c1.aidboss.domain.user.service.UserAccountService
import com.g3c1.aidboss.domain.user.utils.UserConverter
import com.g3c1.aidboss.domain.user.utils.UserUtils
import com.g3c1.aidboss.domain.user.utils.UserValidator
import com.g3c1.aidboss.global.security.jwt.JwtTokenProvider
import com.g3c1.aidboss.global.utils.TokenUtils
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserAccountServiceImpl(
    private val userRepository: UserRepository,
    private val userConverter: UserConverter,
    private val userValidator: UserValidator,
    private val passwordEncoder: PasswordEncoder,
    private val tokenProvider: JwtTokenProvider,
    private val tokenUtils: TokenUtils,
    private val userUtils: UserUtils,
    private val refreshTokenRepository: RefreshTokenRepository
): UserAccountService {
    override fun register(dto: RegisterDto) {
        userValidator.validateUserId(dto.id)
            .let { userConverter.toEntity(dto, passwordEncoder.encode(dto.password))}
            .let { userRepository.save(it) }
    }

    override fun login(dto: LoginDto): TokenDto {
        userValidator.validatePassword(dto)
        val tokenDto = tokenUtils.getTokenDto(dto.id)
        val refreshTokenInfo = RefreshToken(dto.id, tokenDto.refreshToken, tokenProvider.getRefreshTokenExp())
        refreshTokenRepository.save(refreshTokenInfo)
        return tokenDto
    }

    override fun refresh(refreshToken: String): TokenDto {
        val userId: String = tokenProvider.extractIdFromRefreshToken(refreshToken)
        if(!userRepository.existsById(userId)){
            throw UserNotFoundException()
        }
        val redisRefreshToken = refreshTokenRepository.findById(userId).orElseThrow{UserNotFoundException()}
        redisRefreshToken.update(refreshToken,tokenProvider.getRefreshTokenExp())
        refreshTokenRepository.save(redisRefreshToken)
        return tokenUtils.getTokenDto(userId)
    }
    override fun withdrawal() {
        val user = userUtils.getCurrentUser()
        userRepository.delete(user)
    }
}