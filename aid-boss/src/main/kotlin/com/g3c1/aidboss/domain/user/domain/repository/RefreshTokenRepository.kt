package com.g3c1.aidboss.domain.user.domain.repository

import com.g3c1.aidboss.domain.user.domain.entity.RefreshToken
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository: CrudRepository<RefreshToken,String> {
}