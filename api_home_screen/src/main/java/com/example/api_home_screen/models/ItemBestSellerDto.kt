package com.example.api_home_screen.models

import com.google.gson.annotations.SerializedName

data class ItemBestSellerDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("is_favorites")
    val isFavorites: Boolean?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("price_without_discount")
    val priceWithoutDiscount: Double?,
    @SerializedName("discount_price")
    val discountPrice: Double?,
    @SerializedName("picture")
    val picture: String?,
)
