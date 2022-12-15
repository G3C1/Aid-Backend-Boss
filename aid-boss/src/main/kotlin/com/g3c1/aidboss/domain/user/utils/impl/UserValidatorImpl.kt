package com.g3c1.aidboss.domain.user.utils.impl

import com.g3c1.aidboss.domain.user.domain.entity.User
import com.g3c1.aidboss.domain.user.domain.repository.UserRepository
import com.g3c1.aidboss.domain.user.exception.PasswordMisMatchException
import com.g3c1.aidboss.domain.user.exception.UserAlreadyExistException
import com.g3c1.aidboss.domain.user.presentation.data.dto.LoginDto
import com.g3c1.aidboss.domain.user.utils.UserUtils
import com.g3c1.aidboss.domain.user.utils.UserValidator
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class UserValidatorImpl(
    private val userRepository: UserRepository,
    private val userUtils: UserUtils,
    private val passwordEncoder: PasswordEncoder
): UserValidator {
    override fun validateUserId(userId : String) {
        if(userRepository.existsById(userId)) throw UserAlreadyExistException()
    }

    override fun validatePassword(dto: LoginDto) {
        val user: User = userUtils.findUserById(dto.id)
        validatePasswordIsMatch(user.password, dto.password)
    }
    private fun validatePasswordIsMatch(password: String, loginPassword: String) {
        if(!passwordEncoder.matches(loginPassword, password)){
            throw PasswordMisMatchException()
        }else return
    }
}