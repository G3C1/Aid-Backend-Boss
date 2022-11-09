package com.g3c1.aidboss.domain.food.service

import com.g3c1.aidboss.domain.food.presentaion.data.dto.CategoryFoodListDto

interface FoodService {
    fun findFoodListByCategory(): List<CategoryFoodListDto>
}