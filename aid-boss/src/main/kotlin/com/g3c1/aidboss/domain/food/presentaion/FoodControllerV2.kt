package com.g3c1.aidboss.domain.food.presentaion

import com.g3c1.aidboss.domain.food.presentaion.data.request.DeleteFoodRequest
import com.g3c1.aidboss.domain.food.presentaion.data.response.CategoryFoodListResponse
import com.g3c1.aidboss.domain.food.service.FoodServiceV2
import com.g3c1.aidboss.domain.food.utils.FoodConverter
import org.jetbrains.annotations.NotNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v2/food")
class FoodControllerV2(
    private val foodServiceV2: FoodServiceV2,
    private val foodConverter: FoodConverter
) {
    @GetMapping("{serialNumber}")
    fun findFood(@NotNull @PathVariable serialNumber: Long):ResponseEntity<List<CategoryFoodListResponse>> =
        foodServiceV2.findFoodListBySerialNumber(serialNumber)
            .let {foodConverter.toResponse(it)}
            .let { ResponseEntity.ok().body(it) }
    @DeleteMapping()
    fun deleteFood(@RequestBody deleteFoodRequest: DeleteFoodRequest):ResponseEntity<Void> =
        foodConverter.toDto(deleteFoodRequest)
            .let { foodServiceV2.deleteFood(it) }
            .let {ResponseEntity.status(HttpStatus.NO_CONTENT).build()}
}