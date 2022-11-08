package com.example.screen_home.domain.models

data class HomeScreenDataDomain(
    val homeStore: List<ItemHomeStoreDomain>,
    val bestSeller: List<ItemBestSellerDomain>
)
