package com.g3c1.aidboss.domain.food.utils.impl

import com.g3c1.aidboss.domain.food.domain.repository.FoodRepository
import com.g3c1.aidboss.domain.food.presentaion.data.dto.CategoryFoodListDto
import com.g3c1.aidboss.domain.food.presentaion.data.response.CategoryFoodListResponse
import com.g3c1.aidboss.domain.food.utils.FoodConverter
import org.springframework.stereotype.Component

@Component
class FoodConverterImpl(
    private val foodRepository: FoodRepository
):FoodConverter {
    override fun toResponse(categoryFoodListDto: List<CategoryFoodListDto>): List<CategoryFoodListResponse> =
        categoryFoodListDto.toList().map {
            CategoryFoodListResponse(it.id, it.category, foodList = it.foodList.map
            { food -> CategoryFoodListResponse.FoodInfoResponse(food.id, food.name, food.img, food.description, food.servings, food.price) }) }
}