package com.g3c1.aidboss.domain.food.utils.impl

import com.g3c1.aidboss.domain.category.domain.entity.Category
import com.g3c1.aidboss.domain.food.domain.repository.FoodRepository
import com.g3c1.aidboss.domain.food.presentaion.data.dto.CategoryFoodListDto
import com.g3c1.aidboss.domain.food.utils.FoodUtils
import org.springframework.stereotype.Component

@Component
class FoodUtilsImpl(
    private val foodRepository: FoodRepository
):FoodUtils {
    override fun findFoodByCategory(category: Category): List<CategoryFoodListDto.FoodDto> =
        foodRepository.findByCategory(category)
            .map { CategoryFoodListDto.FoodDto(it.id,it.name,it.img,it.description,it.servings,it.price) }
}