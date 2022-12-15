package com.g3c1.aidboss.domain.food.service.impl

import com.g3c1.aidboss.domain.category.utils.CategoryUtils
import com.g3c1.aidboss.domain.food.domain.entity.Food
import com.g3c1.aidboss.domain.food.domain.repository.FoodRepository
import com.g3c1.aidboss.domain.food.exception.FoodNotFoundException
import com.g3c1.aidboss.domain.food.presentaion.data.dto.FoodListDto
import com.g3c1.aidboss.domain.food.presentaion.data.dto.DeleteFoodDto
import com.g3c1.aidboss.domain.food.presentaion.data.dto.UpdateFoodDto
import com.g3c1.aidboss.domain.food.service.FoodServiceV2
import com.g3c1.aidboss.domain.food.utils.FoodUtils
import com.g3c1.aidboss.domain.store.utils.StoreUtils
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FoodServiceV2Impl(
    private val storeUtils: StoreUtils,
    private val categoryUtils: CategoryUtils,
    private val foodUtils: FoodUtils,
    private val foodRepository: FoodRepository,
) : FoodServiceV2 {
    @Transactional(readOnly = true, rollbackFor = [Exception::class])
    override fun findFoodListBySerialNumber(serialNumber: Long): List<FoodListDto> =
        storeUtils.findStoreBySerialNumber(serialNumber)
            .let { categoryUtils.findAllCategoryByStore(it) }
            .map { category-> FoodListDto(category.id,category.name,foodUtils.findFoodByCategory(category)) }

    @Transactional(rollbackFor = [Exception::class])
    override fun deleteFood(dto: DeleteFoodDto) {
        val foodList: List<Food> = dto.foodIdList
            .map { foodRepository.findById(it).orElseThrow { FoodNotFoundException() } }

        foodRepository.deleteAll(foodList)
    }
    @Transactional(rollbackFor = [Exception::class])
    override fun updateFood(dto: UpdateFoodDto) {
        val food: Food = foodRepository.findById(dto.foodId).orElseThrow { FoodNotFoundException() }
        food.updateFood(dto,categoryUtils.findById(dto.categoryId))
    }
}