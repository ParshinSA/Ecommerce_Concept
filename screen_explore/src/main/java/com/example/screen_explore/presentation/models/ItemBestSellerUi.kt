package com.example.screen_explore.presentation.models

import com.example.common.presentation.interfaces.DisplayableItem

data class ItemBestSellerUi(
    val id: Int,
    val isFavorites: Boolean,
    val title: String,
    val priceWithoutDiscount: String,
    val discountPrice: String,
    val picture: String,
    override val itemHashCode: Int = id.hashCode(),
) : DisplayableItem
