package com.g3c1.aidboss.domain.food.service.impl

import com.g3c1.aidboss.domain.category.utils.CategoryUtils
import com.g3c1.aidboss.domain.food.presentaion.data.dto.CategoryFoodListDto
import com.g3c1.aidboss.domain.food.service.FoodServiceV2
import com.g3c1.aidboss.domain.food.utils.FoodUtils
import com.g3c1.aidboss.domain.store.utils.StoreUtlis
import org.springframework.stereotype.Service

@Service
class FoodServiceV2Impl(
    private val storeUtils: StoreUtlis,
    private val categoryUtils: CategoryUtils,
    private val foodUtils: FoodUtils
):FoodServiceV2 {
    override fun findFoodListBySerialNumber(serialNumber: Long): List<CategoryFoodListDto> =
        storeUtils.findStoreBySerialNumber(serialNumber)
            .let { categoryUtils.findAllCategoryByStore(it) }
            .map { category-> CategoryFoodListDto(category.id,category.name,foodUtils.findFoodByCategory(category)) }
}