package com.g3c1.aidboss.domain.user.utils

import com.g3c1.aidboss.domain.user.domain.entity.User

interface UserUtils {
    fun findUserById(id: String): User
    fun getCurrentUser(): User
}