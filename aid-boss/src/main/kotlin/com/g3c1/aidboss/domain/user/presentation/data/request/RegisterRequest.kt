package com.g3c1.aidboss.domain.user.presentation.data.request

import org.jetbrains.annotations.NotNull
import javax.validation.constraints.Pattern

data class RegisterRequest (
    @field:NotNull
    val id: String,
    @field:NotNull
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
        message = "비밀번호에 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.")
    val password: String,
    @field:NotNull
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{2,10}$", message = "닉네임은 특수문자를 제외한 2~10자리여야 합니다.")
    val name:String
)