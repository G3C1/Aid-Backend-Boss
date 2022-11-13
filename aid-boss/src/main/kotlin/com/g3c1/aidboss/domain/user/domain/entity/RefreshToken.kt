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
    val token:String,
    @TimeToLive
    val timeToLive: Long
)
