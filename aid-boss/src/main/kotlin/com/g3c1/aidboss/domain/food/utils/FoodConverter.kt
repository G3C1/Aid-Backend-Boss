package com.g3c1.aidboss.domain.food.utils

import com.g3c1.aidboss.domain.category.domain.entity.Category
import com.g3c1.aidboss.domain.food.domain.entity.Food
import com.g3c1.aidboss.domain.food.presentaion.data.dto.CategoryFoodListDto
import com.g3c1.aidboss.domain.food.presentaion.data.dto.CreateFoodDto
import com.g3c1.aidboss.domain.food.presentaion.data.request.CreateFoodRequest
import com.g3c1.aidboss.domain.food.presentaion.data.response.CategoryFoodListResponse

interface FoodConverter {
    fun toDto(createFoodRequest: CreateFoodRequest) : CreateFoodDto
    fun toEntity(foodInfo: CreateFoodDto.FoodInfo, category: Category): Food
    fun toResponse(categoryFoodListDto: List<CategoryFoodListDto>): List<CategoryFoodListResponse>
}