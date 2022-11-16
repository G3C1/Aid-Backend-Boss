package com.g3c1.aidboss.domain.food.utils.impl

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
import com.g3c1.aidboss.domain.food.utils.FoodConverter
import org.springframework.stereotype.Component

@Component
class FoodConverterImpl :FoodConverter {
    override fun toDto(request: CreateFoodRequest): CreateFoodDto =
        CreateFoodDto(request.foodName,request.foodImg,request.foodDescription,request.servings,request.price,request.categoryId )

    override fun toDto(requset: DeleteFoodRequest): DeleteFoodDto =
        DeleteFoodDto(requset.foodIdList)

    override fun toDto(request: UpdateFoodRequest): UpdateFoodDto =
        UpdateFoodDto(request.foodId,request.foodName,request.foodImg,request.foodDescription,request.servings,request.price,request.categoryId)

    override fun toEntity(dto: CreateFoodDto, entity: Category): Food =
        Food(dto.foodName,dto.foodImg,dto.foodDescription,dto.servings,dto.price,entity)

    override fun toResponse(dto: List<FoodListDto>): List<FoodListResponse> =
        dto.toList()
            .map { FoodListResponse(it.id, it.category,
                it.foodList.map { food -> FoodListResponse.FoodInfoResponse(food.id, food.name, food.img, food.description, food.servings, food.price) }) }
}