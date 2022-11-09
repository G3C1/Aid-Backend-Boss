package com.g3c1.aidboss.domain.food.domain.repository

import com.g3c1.aidboss.domain.category.domain.entity.Category
import com.g3c1.aidboss.domain.food.domain.entity.Food
import org.springframework.data.repository.CrudRepository

interface FoodRepository: CrudRepository<Food,Long> {
    fun findByCategory(category: Category): List<Food>
}