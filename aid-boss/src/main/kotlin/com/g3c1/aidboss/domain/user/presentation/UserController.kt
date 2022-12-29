package com.g3c1.aidboss.domain.user.presentation

import com.g3c1.aidboss.domain.user.presentation.data.request.LoginRequest
import com.g3c1.aidboss.domain.user.presentation.data.request.RegisterRequest
import com.g3c1.aidboss.domain.user.presentation.data.response.TokenResponse
import com.g3c1.aidboss.domain.user.service.UserAccountService
import com.g3c1.aidboss.domain.user.utils.UserConverter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("api/v2/user")
class UserController(
    private val userAccountService: UserAccountService,
    private val userConverter: UserConverter
) {
    @PostMapping
    fun register(@Valid     @RequestBody registerRequest: RegisterRequest):ResponseEntity<Void> =
        userConverter.toDto(registerRequest)
            .let { userAccountService.register(it) }
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }
    @PostMapping("/login")
    fun login(@Valid @RequestBody loginRequest: LoginRequest): ResponseEntity<TokenResponse> =
        userConverter.toDto(loginRequest)
            .let { userAccountService.login(it) }
            .let { userConverter.toResponse(it) }
            .let { ResponseEntity.ok(it) }
    @PatchMapping
    fun refresh(@RequestHeader("Refresh-Token")refreshToken: String): ResponseEntity<TokenResponse> =
         userAccountService.refresh(refreshToken)
            .let { userConverter.toResponse(it) }
            .let { ResponseEntity.ok(it) }

    @DeleteMapping
    fun withdrawal(): ResponseEntity<Void>{
        userAccountService.withdrawal()
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }
}