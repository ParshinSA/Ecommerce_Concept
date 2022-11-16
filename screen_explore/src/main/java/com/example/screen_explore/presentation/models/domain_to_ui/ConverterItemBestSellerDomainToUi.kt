package com.example.screen_explore.presentation.models.domain_to_ui

import com.example.screen_explore.domain.models.ItemBestSellerDomain
import com.example.screen_explore.presentation.models.ItemBestSellerUi

fun ItemBestSellerDomain.toItemBestSellerUi(): ItemBestSellerUi {
    return ItemBestSellerUi(
        id = id,
        isFavorites = isFavorites,
        title = title,
        priceWithoutDiscount = "$$priceWithoutDiscount",
        discountPrice = "$$discountPrice",
        picture = picture
    )
}
