package com.g3c1.aidboss.domain.user.utils.impl

import com.g3c1.aidboss.domain.user.domain.entity.User
import com.g3c1.aidboss.domain.user.domain.repository.UserRepository
import com.g3c1.aidboss.domain.user.exception.UserNotFoundException
import com.g3c1.aidboss.domain.user.utils.UserUtils
import org.springframework.stereotype.Component

@Component
class UserUtilsImpl(
    private val userRepository: UserRepository
): UserUtils {
    override fun findUserById(id: String): User = userRepository.findUserById(id)?:throw UserNotFoundException()
}