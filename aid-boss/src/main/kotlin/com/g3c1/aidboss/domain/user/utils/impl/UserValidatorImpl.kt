package com.g3c1.aidboss.domain.user.utils.impl

import com.g3c1.aidboss.domain.user.domain.repository.UserRepository
import com.g3c1.aidboss.domain.user.exception.UserAlreadyExistException
import com.g3c1.aidboss.domain.user.utils.UserValidator
import org.springframework.stereotype.Component

@Component
class UserValidatorImpl(
    private val userRepository: UserRepository
): UserValidator {
    override fun validateUserId(userId : String) {
        if(userRepository.existsById(userId)) throw UserAlreadyExistException()
    }


}