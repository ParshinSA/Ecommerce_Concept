package com.example.screen_home.domain.interactors

import com.example.screen_home.domain.models.HomeScreenDataDomain
import com.example.screen_home.domain.repositories.HomeScreeRepository
import io.reactivex.Single
import javax.inject.Inject

class HomeScreenInteractorImpl @Inject constructor(
    private val homeScreeRepository: HomeScreeRepository
) : HomeScreenInteractor {

    override fun getHomeScreenData(): Single<HomeScreenDataDomain> {
        return homeScreeRepository.getHomeScreenData()
    }

}