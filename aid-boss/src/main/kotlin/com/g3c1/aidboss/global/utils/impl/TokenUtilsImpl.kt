package com.g3c1.aidboss.global.utils.impl

import com.g3c1.aidboss.domain.user.presentation.data.dto.TokenDto
import com.g3c1.aidboss.global.security.jwt.JwtTokenProvider
import com.g3c1.aidboss.global.utils.TokenUtils
import org.springframework.stereotype.Component
import java.time.ZonedDateTime

@Component
class TokenUtilsImpl(
    private val tokenProvider: JwtTokenProvider
) : TokenUtils {
    override fun getTokenDto(userId: String): TokenDto {
        val accessToken: String = tokenProvider.generateAccessToken(userId)
        val refreshToken: String = tokenProvider.generateRefreshToken(userId)
        val expiredAt: ZonedDateTime = tokenProvider.getExpiredTime()
        return TokenDto(accessToken, refreshToken, expiredAt)
    }
}