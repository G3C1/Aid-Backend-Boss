package com.g3c1.aidboss.domain.user.presentation.data.request

import org.jetbrains.annotations.NotNull

data class RegisterRequest (
    @field:NotNull
    val id: String,
    @field:NotNull
    val password: String,
    @field:NotNull
    val name:String
)