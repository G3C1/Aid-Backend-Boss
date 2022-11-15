package com.g3c1.aidboss.domain.food.service

import com.g3c1.aidboss.domain.food.presentaion.data.dto.CategoryFoodListDto

interface FoodServiceV2 {
    fun findFoodListBySerialNumber(serialNumber: Long): List<CategoryFoodListDto>
}