package com.g3c1.aidboss.domain.food.service.impl

import com.g3c1.aidboss.domain.category.domain.entity.Category
import com.g3c1.aidboss.domain.category.utils.CategoryUtils
import com.g3c1.aidboss.domain.food.domain.repository.FoodRepository
import com.g3c1.aidboss.domain.food.presentaion.data.dto.CategoryFoodListDto
import com.g3c1.aidboss.domain.food.presentaion.data.dto.CreateFoodDto
import com.g3c1.aidboss.domain.food.service.FoodService
import com.g3c1.aidboss.domain.food.utils.FoodConverter
import com.g3c1.aidboss.domain.food.utils.FoodUtils
import org.springframework.data.jpa.repository.Lock
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.LockModeType

@Service
class FoodServiceImpl(
    private val foodRepository: FoodRepository,
    private val categoryUtils: CategoryUtils,
    private val foodConverter: FoodConverter,
    private val foodUtils: FoodUtils
): FoodService {
    @Transactional(readOnly = true, rollbackFor = [Exception::class])
    override fun findFoodListByCategory(): List<CategoryFoodListDto> =
        categoryUtils.findAllCategory()
            .map {category-> CategoryFoodListDto(category.id,category.name,foodUtils.findFoodByCategory(category))
    }

    @Transactional(rollbackFor = [Exception::class])
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    override fun createFood(createFoodDto: CreateFoodDto) {
        createFoodDto.foodInfoList
            .map { foodConverter.toEntity(it,categoryUtils.findById(it.categoryId))}
            .let { foodRepository.saveAll(it) }
    }
}