package com.example.screen_home.domain.repositories

import com.example.screen_home.domain.models.HomeScreenDataDomain
import io.reactivex.Single

interface HomeScreeRepository {
    fun getHomeScreenData(): Single<HomeScreenDataDomain>
}