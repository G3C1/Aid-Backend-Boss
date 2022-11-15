package com.g3c1.aidboss.domain.food.presentaion

import com.g3c1.aidboss.domain.food.service.FoodServiceV2
import com.g3c1.aidboss.domain.food.utils.FoodConverter
import org.jetbrains.annotations.NotNull
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v2/food")
class FoodControllerV2(
    private val foodServiceV2: FoodServiceV2,
    private val foodConverter: FoodConverter
) {
    @GetMapping("{serialNumber}")
    fun findFood(@NotNull @PathVariable serialNumber: Long) =
        foodServiceV2.findFoodListBySerialNumber(serialNumber)
            .let {foodConverter.toResponse(it)}
            .let { ResponseEntity.ok().body(it) }
}