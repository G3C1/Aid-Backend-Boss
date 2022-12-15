package com.g3c1.aidboss.domain.food.service.impl

import com.g3c1.aidboss.domain.category.utils.CategoryUtils
import com.g3c1.aidboss.domain.food.domain.repository.FoodRepository
import com.g3c1.aidboss.domain.food.presentaion.data.dto.FoodListDto
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
    override fun findFoodListByCategory(): List<FoodListDto> =
        categoryUtils.findAllCategory()
            .map {category-> FoodListDto(category.id,category.name,foodUtils.findFoodByCategory(category))
    }

    @Transactional(rollbackFor = [Exception::class])
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    override fun createFood(dto: CreateFoodDto) {
        foodConverter.toEntity(dto,categoryUtils.findById(dto.categoryId))
            .let { foodRepository.save(it) }
    }
}