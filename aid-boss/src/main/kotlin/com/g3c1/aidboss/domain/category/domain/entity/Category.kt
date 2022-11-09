package com.g3c1.aidboss.domain.category.domain.entity

import com.g3c1.aidboss.domain.store.domain.entity.Store
import com.g3c1.temiuser.global.entity.BaseIdEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
data class Category(
    @Column(nullable = false)
    val name: String,
    @ManyToOne
    @JoinColumn(name = "store_id")
    val store: Store
):BaseIdEntity()
