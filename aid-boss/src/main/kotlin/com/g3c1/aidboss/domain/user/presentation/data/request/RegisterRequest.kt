package com.g3c1.aidboss.domain.user.presentation.data.request

import org.jetbrains.annotations.NotNull
import javax.validation.constraints.Pattern

data class RegisterRequest (
    @field:NotNull
    val id: String,
    @field:NotNull
    @field:Pattern(regexp = "^.(?=^.{8,20}\$)(?=.\\d)(?=.[a-zA-Z])(?=.[!@#\$%^&+=]).*\$")
    val password: String,
    @field:NotNull
    @field:Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{2,10}$")
    val name:String
)