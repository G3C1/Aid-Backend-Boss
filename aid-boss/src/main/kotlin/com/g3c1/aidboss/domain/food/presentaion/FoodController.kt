package com.g3c1.aidboss.domain.food.presentaion

import com.g3c1.aidboss.domain.food.presentaion.data.response.CategoryFoodListResponse
import com.g3c1.aidboss.domain.food.service.FoodService
import com.g3c1.aidboss.domain.food.utils.FoodConverter
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/food")
class FoodController(
    private val foodService: FoodService,
    private val foodConverter: FoodConverter
) {
    @GetMapping
    fun findFoodListByCategory(): ResponseEntity<List<CategoryFoodListResponse>> =
        foodService.findFoodListByCategory()
            .let { foodConverter.toResponse(it) }
            .let { ResponseEntity.ok().body(it)}
}