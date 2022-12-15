package com.g3c1.aidboss.domain.food.presentaion.data.dto


data class CreateFoodDto (
    val foodName: String,
    val foodImg: String,
    val foodDescription: String,
    val servings: Long,
    val price: Long,
    val categoryId: Long
)
