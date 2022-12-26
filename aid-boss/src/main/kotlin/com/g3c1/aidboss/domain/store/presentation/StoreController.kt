package com.g3c1.aidboss.domain.store.presentation

import com.g3c1.aidboss.domain.store.presentation.data.request.CreateStoreRequest
import com.g3c1.aidboss.domain.store.presentation.data.response.MyStoreResponse
import com.g3c1.aidboss.domain.store.service.StoreService
import com.g3c1.aidboss.domain.store.utils.StoreConverter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("api/v2/store")
class StoreController(
    private val storeService: StoreService,
    private val storeConverter: StoreConverter
) {
    @PostMapping
    fun createStore(@Valid @RequestBody createStoreRequest: CreateStoreRequest): ResponseEntity<Void> =
        storeConverter.toDto(createStoreRequest)
            .let { storeService.createStore(it) }
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }
    @GetMapping
    fun findAllById():ResponseEntity<MyStoreResponse> =
        storeService.findAllStoreById()
            .let { storeConverter.toResponse(it) }
            .let { ResponseEntity.ok().body(it) }
}