package com.g3c1.aidboss.domain.food.service

import com.g3c1.aidboss.domain.food.presentaion.data.dto.FoodListDto
import com.g3c1.aidboss.domain.food.presentaion.data.dto.CreateFoodDto

interface FoodService {
    fun findFoodListByCategory(): List<FoodListDto>
    fun createFood(dto: CreateFoodDto)
}