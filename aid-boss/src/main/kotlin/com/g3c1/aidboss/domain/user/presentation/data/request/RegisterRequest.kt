package com.g3c1.aidboss.domain.user.presentation.data.request

import org.jetbrains.annotations.NotNull
import javax.validation.constraints.Pattern

data class RegisterRequest (
    @field:NotNull
    val id: String,
    @field:NotNull
   // @field:Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\\\d)(?=.*\\\\W).{8,20}\$",message = "비밀번호를 확인해주세요")
    val password: String,
    @field:NotNull
    //@field:Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{2,10}$")
    val name:String
)