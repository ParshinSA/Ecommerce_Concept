package com.example.screen_explore.domain.models

data class ExploreScreenDataDomain(
    val homeStore: List<ItemHomeStoreDomain>,
    val bestSeller: List<ItemBestSellerDomain>
)
