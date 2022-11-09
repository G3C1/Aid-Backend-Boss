package com.g3c1.aidboss.domain.food.service

import com.g3c1.aidboss.domain.food.presentaion.data.dto.CategoryFoodListDto
import com.g3c1.aidboss.domain.food.presentaion.data.dto.CreateFoodDto

interface FoodService {
    fun findFoodListByCategory(): List<CategoryFoodListDto>
    fun createFood(createFoodDto: CreateFoodDto)
}