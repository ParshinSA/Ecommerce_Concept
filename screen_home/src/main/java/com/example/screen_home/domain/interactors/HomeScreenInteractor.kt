package com.example.screen_home.domain.interactors

import com.example.screen_home.domain.models.HomeScreenDataDomain
import io.reactivex.Single

interface HomeScreenInteractor {
    fun getHomeScreenData(): Single<HomeScreenDataDomain>
}