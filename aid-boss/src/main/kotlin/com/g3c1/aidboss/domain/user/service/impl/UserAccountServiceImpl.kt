package com.g3c1.aidboss.domain.user.service.impl

import com.g3c1.aidboss.domain.user.domain.entity.RefreshToken
import com.g3c1.aidboss.domain.user.domain.repository.RefreshTokenRepository
import com.g3c1.aidboss.domain.user.domain.repository.UserRepository
import com.g3c1.aidboss.domain.user.presentation.data.dto.LoginDto
import com.g3c1.aidboss.domain.user.presentation.data.dto.RegisterDto
import com.g3c1.aidboss.domain.user.presentation.data.dto.TokenDto
import com.g3c1.aidboss.domain.user.service.UserAccountService
import com.g3c1.aidboss.domain.user.utils.UserConverter
import com.g3c1.aidboss.domain.user.utils.UserValidator
import com.g3c1.aidboss.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.time.ZonedDateTime

@Service
class UserAccountServiceImpl(
    private val userRepository: UserRepository,
    private val userConverter: UserConverter,
    private val userValidator: UserValidator,
    private val passwordEncoder: PasswordEncoder,
    private val tokenProvider: JwtTokenProvider,
    private val refreshTokenRepository: RefreshTokenRepository
): UserAccountService {
    override fun register(registerDto: RegisterDto) {
        userValidator.validateUserId(registerDto.id)
            .let { userConverter.toEntity(registerDto,passwordEncoder.encode(registerDto.password))}
            .let { userRepository.save(it) }
    }

    override fun login(loginDto: LoginDto): TokenDto {
        userValidator.validatePassword(loginDto)
        val accessToken: String = tokenProvider.generateAccessToken(loginDto.id)
        val refreshToken: String = tokenProvider.generateRefreshToken(loginDto.id)
        val expiredAt: ZonedDateTime = tokenProvider.getExpiredTime()
        val refreshTokenInfo: RefreshToken = RefreshToken(loginDto.id,accessToken,1)
        refreshTokenRepository.save(refreshTokenInfo)
        return TokenDto(accessToken,refreshToken,expiredAt)
    }
}