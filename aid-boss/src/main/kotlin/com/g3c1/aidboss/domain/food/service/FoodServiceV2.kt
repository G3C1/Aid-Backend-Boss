package com.g3c1.aidboss.domain.food.service

import com.g3c1.aidboss.domain.food.presentaion.data.dto.CategoryFoodListDto
import com.g3c1.aidboss.domain.food.presentaion.data.dto.DeleteFoodDto
import com.g3c1.aidboss.domain.food.presentaion.data.dto.UpdateFoodDto

interface FoodServiceV2 {
    fun findFoodListBySerialNumber(serialNumber: Long): List<CategoryFoodListDto>
    fun deleteFood(deleteFoodDto: DeleteFoodDto)
    fun updateFood(updateFoodDto: UpdateFoodDto)
}