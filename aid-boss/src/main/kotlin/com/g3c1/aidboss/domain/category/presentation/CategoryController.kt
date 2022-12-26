package com.g3c1.aidboss.domain.category.presentation

import com.g3c1.aidboss.domain.category.presentation.data.request.CreateCategoryRequest
import com.g3c1.aidboss.domain.category.service.CategoryService
import com.g3c1.aidboss.domain.category.utils.CategoryConverter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("api/v1/category")
class CategoryController(
    private val categoryService: CategoryService,
    private val categoryConverter: CategoryConverter
) {
    @PostMapping
    fun createCategory(@Valid @RequestBody createCategoryListRequest: CreateCategoryRequest): ResponseEntity<Void> =
        categoryConverter.toDto(createCategoryListRequest)
            .let { categoryService.createCategory(it) }
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }
}