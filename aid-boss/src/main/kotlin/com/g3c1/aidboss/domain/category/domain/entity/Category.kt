package com.g3c1.aidboss.domain.category.domain.entity

import com.g3c1.temiuser.global.entity.BaseIdEntity
import javax.persistence.Column
import javax.persistence.Entity

@Entity
data class Category(
    @Column(nullable = false)
    val name: String
):BaseIdEntity()
