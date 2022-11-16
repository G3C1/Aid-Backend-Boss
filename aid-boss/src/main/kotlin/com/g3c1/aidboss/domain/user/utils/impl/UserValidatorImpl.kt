package com.g3c1.aidboss.domain.user.utils.impl

import com.g3c1.aidboss.domain.user.domain.entity.User
import com.g3c1.aidboss.domain.user.domain.repository.UserRepository
import com.g3c1.aidboss.domain.user.exception.PasswordDisMatchException
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

    override fun validatePassword(loginDto: LoginDto) {
        val user: User = userUtils.findUserById(loginDto.id)
        validatePasswordIsMatch(user.password, loginDto.password)
    }
    private fun validatePasswordIsMatch(password: String, loginPassword: String) {
        if(!passwordEncoder.matches(password,loginPassword)){
            throw PasswordDisMatchException()
        }else return
    }
}