package com.g3c1.aidboss.domain.user.domain.repository

import com.g3c1.aidboss.domain.user.domain.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User,String> {
    fun findUserById(id: String): User?
}