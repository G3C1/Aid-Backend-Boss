package com.g3c1.aidboss.domain.food.utils

import com.g3c1.aidboss.domain.food.presentaion.data.dto.CategoryFoodListDto
import com.g3c1.aidboss.domain.food.presentaion.data.response.CategoryFoodListResponse

interface FoodConverter {
    fun toResponse(categoryFoodListDto: List<CategoryFoodListDto>): List<CategoryFoodListResponse>
}