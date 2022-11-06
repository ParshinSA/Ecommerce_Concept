package com.example.api_my_cart_screen.models

import com.google.gson.annotations.SerializedName

data class ItemBasketDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("images")
    val images: String?,
    @SerializedName("price")
    val price: Double?,
    @SerializedName("title")
    val title: String?
)
