package com.g3c1.aidboss.domain.store.presentation.data.response

data class MyStoreResponse (
        val userName: String,
        val storeList: List<StoreInfoResponse>
){
    data class StoreInfoResponse (
        val name: String,
        val img: String,
        val description: String
    )
}