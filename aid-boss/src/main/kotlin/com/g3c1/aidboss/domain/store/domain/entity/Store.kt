package com.g3c1.aidboss.domain.store.domain.entity

import com.g3c1.aidboss.domain.user.domain.entity.User
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Store(
    @Id
    @Column(name= "serial_number")
    val serialNumber:Long,
    val name: String,
    val description: String,
    val img: String,
    @ManyToOne
    val user:User
)
