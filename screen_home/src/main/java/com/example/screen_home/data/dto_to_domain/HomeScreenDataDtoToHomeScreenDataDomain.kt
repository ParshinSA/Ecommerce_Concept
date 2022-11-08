package com.example.screen_home.data.dto_to_domain

import com.example.api_home_screen.models.HomeScreenDataDto
import com.example.api_home_screen.models.ItemBestSellerDto
import com.example.api_home_screen.models.ItemHomeStoreDto
import com.example.screen_home.domain.models.HomeScreenDataDomain
import com.example.screen_home.domain.models.ItemBestSellerDomain
import com.example.screen_home.domain.models.ItemHomeStoreDomain

fun HomeScreenDataDto.toHomeScreenDataDomain(): HomeScreenDataDomain {
    val bestSeller = bestSeller ?: emptyList()
    val resultBestSeller = bestSeller.map { itemBestSellerDto: ItemBestSellerDto? ->
        val item = itemBestSellerDto ?: return@map null

        val priceWithoutDiscount = item.priceWithoutDiscount ?: return@map null
        val discountPrice = item.discountPrice ?: return@map null
        val isFavorites = item.isFavorites ?: return@map null
        val picture = item.picture ?: return@map null
        val title = item.title ?: return@map null
        val id = item.id ?: return@map null

        return@map ItemBestSellerDomain(
            priceWithoutDiscount = priceWithoutDiscount,
            discountPrice = discountPrice,
            isFavorites = isFavorites,
            picture = picture,
            title = title,
            id = id,
        )
    }.filterNotNull()

    val homeStore = homeStore ?: emptyList()
    val resultHomeStore = homeStore.map { itemHomeStoreDto: ItemHomeStoreDto? ->
        val item = itemHomeStoreDto ?: return@map null

        val subtitle = item.subtitle ?: return@map null
        val picture = item.picture ?: return@map null
        val isBuy = item.isBuy ?: return@map null
        val isNew = item.isNew ?: return@map null
        val title = item.title ?: return@map null
        val id = item.id ?: return@map null

        return@map ItemHomeStoreDomain(
            subtitle = subtitle,
            picture = picture,
            isBuy = isBuy,
            isNew = isNew,
            title = title,
            id = id,
        )
    }.filterNotNull()

    return HomeScreenDataDomain(
        homeStore = resultHomeStore,
        bestSeller = resultBestSeller
    )
}


