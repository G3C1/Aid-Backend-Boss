package com.g3c1.aidboss.domain.food.utils

import com.g3c1.aidboss.domain.category.domain.entity.Category
import com.g3c1.aidboss.domain.food.domain.entity.Food
import com.g3c1.aidboss.domain.food.presentaion.data.dto.FoodListDto
import com.g3c1.aidboss.domain.food.presentaion.data.dto.CreateFoodDto
import com.g3c1.aidboss.domain.food.presentaion.data.dto.DeleteFoodDto
import com.g3c1.aidboss.domain.food.presentaion.data.dto.UpdateFoodDto
import com.g3c1.aidboss.domain.food.presentaion.data.request.CreateFoodRequest
import com.g3c1.aidboss.domain.food.presentaion.data.request.DeleteFoodRequest
import com.g3c1.aidboss.domain.food.presentaion.data.request.UpdateFoodRequest
import com.g3c1.aidboss.domain.food.presentaion.data.response.FoodListResponse

interface FoodConverter {
    fun toDto(request: CreateFoodRequest): CreateFoodDto
    fun toDto(request: DeleteFoodRequest): DeleteFoodDto
    fun toDto(request: UpdateFoodRequest): UpdateFoodDto
    fun toEntity(dto: CreateFoodDto, entity: Category): Food
    fun toResponse(dto: List<FoodListDto>): List<FoodListResponse>
}