package com.g3c1.aidboss.domain.food.utils.impl

import com.g3c1.aidboss.domain.category.domain.entity.Category
import com.g3c1.aidboss.domain.food.domain.entity.Food
import com.g3c1.aidboss.domain.food.presentaion.data.dto.CategoryFoodListDto
import com.g3c1.aidboss.domain.food.presentaion.data.dto.CreateFoodDto
import com.g3c1.aidboss.domain.food.presentaion.data.dto.DeleteFoodDto
import com.g3c1.aidboss.domain.food.presentaion.data.dto.UpdateFoodDto
import com.g3c1.aidboss.domain.food.presentaion.data.request.CreateFoodRequest
import com.g3c1.aidboss.domain.food.presentaion.data.request.DeleteFoodRequest
import com.g3c1.aidboss.domain.food.presentaion.data.request.UpdateFoodRequest
import com.g3c1.aidboss.domain.food.presentaion.data.response.CategoryFoodListResponse
import com.g3c1.aidboss.domain.food.utils.FoodConverter
import org.springframework.stereotype.Component

@Component
class FoodConverterImpl :FoodConverter {
    override fun toDto(request: CreateFoodRequest): CreateFoodDto =
        CreateFoodDto(request.foodInfoList.map { CreateFoodDto.FoodInfo(it.foodName,it.foodImg,it.foodDescription,it.servings,it.price,it.categoryId) })

    override fun toDto(requset: DeleteFoodRequest): DeleteFoodDto =
        DeleteFoodDto(requset.foodIdList)

    override fun toDto(request: UpdateFoodRequest): UpdateFoodDto =
        UpdateFoodDto(request.foodName,request.foodImg,request.foodDescription,request.servings,request.price,request.categoryId)

    override fun toEntity(dto: CreateFoodDto.FoodInfo, entity: Category): Food =
        Food(dto.foodName,dto.foodImg,dto.foodDescription,dto.servings,dto.price,entity)

    override fun toResponse(dto: List<CategoryFoodListDto>): List<CategoryFoodListResponse> =
        dto.toList()
            .map { CategoryFoodListResponse(it.id, it.category,
                it.foodList.map { food -> CategoryFoodListResponse.FoodInfoResponse(food.id, food.name, food.img, food.description, food.servings, food.price) }) }
}