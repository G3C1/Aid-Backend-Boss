package com.g3c1.aidboss.domain.food.utils

import com.g3c1.aidboss.domain.category.domain.entity.Category
import com.g3c1.aidboss.domain.food.presentaion.data.dto.CategoryFoodListDto

interface FoodUtils {
    fun findFoodByCategory(category: Category): List<CategoryFoodListDto.FoodDto>
}