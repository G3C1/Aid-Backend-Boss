package com.g3c1.aidboss.domain.food.utils.impl

import com.g3c1.aidboss.domain.category.domain.entity.Category
import com.g3c1.aidboss.domain.food.domain.entity.Food
import com.g3c1.aidboss.domain.food.presentaion.data.dto.CategoryFoodListDto
import com.g3c1.aidboss.domain.food.presentaion.data.dto.CreateFoodDto
import com.g3c1.aidboss.domain.food.presentaion.data.request.CreateFoodRequest
import com.g3c1.aidboss.domain.food.presentaion.data.response.CategoryFoodListResponse
import com.g3c1.aidboss.domain.food.utils.FoodConverter
import org.springframework.stereotype.Component

@Component
class FoodConverterImpl :FoodConverter {
    override fun toDto(createFoodRequest: CreateFoodRequest): CreateFoodDto =
        CreateFoodDto(createFoodRequest.foodInfoList.map { CreateFoodDto.FoodInfo(it.foodName,it.foodImg,it.foodDescription,it.servings,it.price,it.categoryId) })

    override fun toEntity(foodInfo: CreateFoodDto.FoodInfo, category: Category): Food =
        Food(foodInfo.foodName,foodInfo.foodImg,foodInfo.foodDescription,foodInfo.servings,foodInfo.price,category)

    override fun toResponse(categoryFoodListDto: List<CategoryFoodListDto>): List<CategoryFoodListResponse> =
        categoryFoodListDto.toList().map {
            CategoryFoodListResponse(it.id, it.category, foodList = it.foodList.map
            { food -> CategoryFoodListResponse.FoodInfoResponse(food.id, food.name, food.img, food.description, food.servings, food.price) }) }
}