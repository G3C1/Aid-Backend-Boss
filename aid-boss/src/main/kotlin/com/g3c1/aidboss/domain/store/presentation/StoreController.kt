package com.g3c1.aidboss.domain.store.presentation

import com.g3c1.aidboss.domain.category.presentation.data.request.CreateCategoryRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/store")
class StoreController {
    @PostMapping
    fun createStore(@RequestBody createCategoryRequest: CreateCategoryRequest): ResponseEntity<Void>{
        return ResponseEntity.ok().build()
    }
}