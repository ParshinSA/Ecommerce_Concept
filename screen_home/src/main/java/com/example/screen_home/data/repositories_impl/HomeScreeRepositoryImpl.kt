package com.example.screen_home.data.repositories_impl

import com.example.screen_home.data.data_source.HomeScreenDataDataSource
import com.example.screen_home.data.dto_to_domain.toHomeScreenDataDomain
import com.example.screen_home.domain.models.HomeScreenDataDomain
import com.example.screen_home.domain.repositories.HomeScreeRepository
import io.reactivex.Single
import javax.inject.Inject

class HomeScreeRepositoryImpl @Inject constructor(
    private val dataSource: HomeScreenDataDataSource
) : HomeScreeRepository {

    override fun getHomeScreenData(): Single<HomeScreenDataDomain> {
        return dataSource.getHomeScreenData()
            .map { homeScreenDataDto -> homeScreenDataDto.toHomeScreenDataDomain() }
    }

}