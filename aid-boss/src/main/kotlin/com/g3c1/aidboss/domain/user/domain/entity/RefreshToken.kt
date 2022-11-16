package com.g3c1.aidboss.domain.user.domain.entity

import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed
import javax.persistence.Id

@RedisHash
data class RefreshToken(
    @Id
    val id:String,
    @Indexed
    var token:String,
    @TimeToLive
    var timeToLive: Long
) {
    fun update(refreshToken: String, refreshTokenExp: Long) {
        this.token = refreshToken
        this.timeToLive = refreshTokenExp
    }
}
