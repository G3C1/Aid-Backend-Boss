package com.g3c1.aidboss.domain.food.presentaion

import com.g3c1.aidboss.domain.food.presentaion.data.request.CreateFoodRequest
import com.g3c1.aidboss.domain.food.presentaion.data.response.FoodListResponse
import com.g3c1.aidboss.domain.food.service.FoodService
import com.g3c1.aidboss.domain.food.utils.FoodConverter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("api/v1/food")
class FoodController(
    private val foodService: FoodService,
    private val foodConverter: FoodConverter
) {
    @GetMapping
    fun findFoodList(): ResponseEntity<List<FoodListResponse>> =
        foodService.findFoodListByCategory()
            .let { foodConverter.toResponse(it) }
            .let { ResponseEntity.ok().body(it)}
    @PostMapping
    fun createFood(@Valid @RequestBody createFoodRequest: CreateFoodRequest): ResponseEntity<Void> =
        foodConverter.toDto(createFoodRequest)
            .let { foodService.createFood(it) }
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }
}