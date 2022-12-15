package com.g3c1.aidboss.domain.food.presentaion.data.request

import org.jetbrains.annotations.NotNull

data class UpdateFoodRequest (
    @field: NotNull
    val foodId: Long,
    @field: NotNull
    val foodName :String,
    @field: NotNull
    val foodImg: String,
    @field: NotNull
    val foodDescription: String,
    @field: NotNull
    val servings: Long,
    @field: NotNull
    val price: Long,
    @field: NotNull
    val categoryId: Long
)