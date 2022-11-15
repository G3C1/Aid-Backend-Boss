package com.g3c1.aidboss.domain.food.presentaion.data.request

import org.jetbrains.annotations.NotNull

data class DeleteFoodRequest (
    @field:NotNull
    val foodIdList: List<Long>
)