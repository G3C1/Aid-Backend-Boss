package com.g3c1.aidboss.domain.category.presentation

import com.g3c1.aidboss.domain.category.presentation.data.request.CreateCategoryRequest
import com.g3c1.aidboss.domain.category.presentation.data.response.CategoryResponse
import com.g3c1.aidboss.domain.category.service.CategoryServiceV2
import com.g3c1.aidboss.domain.category.utils.CategoryConverter
import org.jetbrains.annotations.NotNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("api/v2/category")
class CategoryControllerV2(
    private val categoryConverter: CategoryConverter,
    private val categoryServiceV2: CategoryServiceV2
) {
    @PostMapping("{serial_number}")
    fun createCategory(@Valid @RequestBody createCategoryListRequest: CreateCategoryRequest,
                       @NotNull @PathVariable("serial_number") serialNumber: Long): ResponseEntity<Void> =
        categoryConverter.toDto(createCategoryListRequest)
            .let { categoryServiceV2.createCategory(it,serialNumber) }
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }
    @GetMapping("{serial_number}")
    fun findCategory(@NotNull @PathVariable("serial_number") serialNumber: Long): ResponseEntity<List<CategoryResponse>> =
        categoryServiceV2.findCategory(serialNumber)
            .map { categoryConverter.toResponse(it) }
            .let { ResponseEntity.ok().body(it)}
}