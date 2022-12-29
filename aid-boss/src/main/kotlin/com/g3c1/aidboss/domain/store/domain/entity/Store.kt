package com.g3c1.aidboss.domain.store.domain.entity

import com.g3c1.aidboss.domain.user.domain.entity.User
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
data class Store(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "serial_number")
    val serialNumber:Long,
    val name: String,
    val description: String,
    val img: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(nullable = false)
    val user:User
)
