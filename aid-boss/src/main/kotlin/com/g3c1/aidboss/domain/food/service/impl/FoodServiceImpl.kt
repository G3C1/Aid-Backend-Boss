package com.g3c1.aidboss.domain.food.service.impl

import com.g3c1.aidboss.domain.category.domain.entity.Category
import com.g3c1.aidboss.domain.category.utils.CategoryUtils
import com.g3c1.aidboss.domain.food.domain.repository.FoodRepository
import com.g3c1.aidboss.domain.food.presentaion.data.dto.CategoryFoodListDto
import com.g3c1.aidboss.domain.food.service.FoodService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FoodServiceImpl(
    private val foodRepository: FoodRepository,
    private val categoryUtils: CategoryUtils
): FoodService {
    @Transactional(readOnly = true, rollbackFor = [Exception::class])
    override fun findFoodListByCategory(): List<CategoryFoodListDto> = categoryUtils.findAllCategory().toList().map {category->
        CategoryFoodListDto(category.id,category.name,findFoodByCategory(category))
    }
    private fun findFoodByCategory(category: Category):List<CategoryFoodListDto.FoodDto> =
        foodRepository.findByCategory(category).toList()
            .map { CategoryFoodListDto.FoodDto(it.id,it.name,it.img,it.description,it.servings,it.price) }
}