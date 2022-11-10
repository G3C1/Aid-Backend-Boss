package com.g3c1.aidboss.domain.user.domain.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class User (
    @Id
    val id: String,
    @Column(nullable = false)
    val password: String,
    @Column(nullable = false)
    val name: String
)