package com.g3c1.aidboss.domain.store.presentation.data.dto

data class MyStoreDto (
    val userName: String,
    val StoreList: List<StoreInfoDto>
){
    data class StoreInfoDto (
        val name: String,
        val img: String,
        val description: String
    )
}