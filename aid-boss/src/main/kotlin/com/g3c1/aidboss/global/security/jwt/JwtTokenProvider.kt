package com.g3c1.aidboss.global.security.jwt

import com.g3c1.aidboss.global.security.auth.AuthDetailService
import com.g3c1.aidboss.global.security.exception.ExpiredTokenException
import com.g3c1.aidboss.global.security.exception.InvalidTokenException
import com.g3c1.aidboss.global.security.properties.JwtProperties
import io.jsonwebtoken.*
import io.jsonwebtoken.security.Keys
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.security.Key
import java.security.SignatureException
import java.time.ZonedDateTime
import java.util.*
import javax.servlet.http.HttpServletRequest


@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties,
    private val authDetailService: AuthDetailService,
) {
    companion object{
        private const val ACCESS_TYPE = "access"
        private const val REFRESH_TYPE = "refresh"
        private const val ACCESS_EXP: Long = 60*15
        private const val REFRESH_EXP: Long = 60*60*24*7
    }

    private fun generateToken(userId: String, type: String, secret: String, exp: Long): String {
        return Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(secret.toByteArray()))
            .claim("userId", userId)
            .claim("type", type)
            .setIssuedAt(Date())
            .setSubject(userId)
            .setExpiration(Date(System.currentTimeMillis() + exp * 1000))
            .compact()
    }

    fun generateAccessToken(userId: String): String =
        generateToken(userId, ACCESS_TYPE, jwtProperties.accessSecret, ACCESS_EXP)

    fun generateRefreshToken(userId: String): String =
        generateToken(userId, REFRESH_TYPE, jwtProperties.refreshSecret, REFRESH_EXP)
    fun getExpiredTime(): ZonedDateTime = ZonedDateTime.now().plusSeconds(ACCESS_EXP)
    fun getRefreshTokenExp():Long = REFRESH_EXP

    fun getAuthentication(token: String): Authentication {
        val userDetails = authDetailService.loadUserByUsername(getTokenSubject(token, jwtProperties.accessSecret))
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    private fun getTokenBody(token: String, secret: String): Claims {
        return try {
            Jwts.parserBuilder()
                .setSigningKey(getSigningKey(secret))
                .build()
                .parseClaimsJws(token)
                .body
        } catch (e: ExpiredJwtException) {
            throw ExpiredTokenException()
        } catch (e: MalformedJwtException) {
            throw InvalidTokenException()
        } catch (e: SignatureException) {
            throw InvalidTokenException()
        }
    }
    private fun getSigningKey(secret: String): Key{
        val byteArray = secret.toByteArray()
        return Keys.hmacShaKeyFor(byteArray)
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val token = request.getHeader("Authorization")
        return if (token != null && token.startsWith("Bearer ")) token.replace("Bearer ", "") else null
    }

    private fun getTokenSubject(token: String, secret: String): String {
        return getTokenBody(token, secret).get("userId", String::class.java)
    }
    fun extractIdFromRefreshToken(token: String): String {
        val refresh = token.replace("Bearer ", "")
        return getTokenSubject(refresh, jwtProperties.refreshSecret)
    }
}
