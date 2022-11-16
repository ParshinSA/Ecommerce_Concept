package com.example.screen_explore.domain.models

data class ItemBestSellerDomain(
    val id: Int,
    val isFavorites: Boolean,
    val title: String,
    val priceWithoutDiscount: Double,
    val discountPrice: Double,
    val picture: String,
)
