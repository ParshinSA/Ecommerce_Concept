package com.example.api_home_screen.models

import com.google.gson.annotations.SerializedName

data class HomeScreenDataDto(
    @SerializedName("home_store")
    val homeStore: List<ItemHomeStoreDto?>,
    @SerializedName("best_seller")
    val bestSeller: List<ItemHomeStoreDto?>
)
