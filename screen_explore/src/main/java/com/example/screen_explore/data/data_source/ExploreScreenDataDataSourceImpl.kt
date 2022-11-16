package com.example.screen_explore.data.data_source

import com.example.api_home_screen.api.HomeMockApi
import com.example.api_home_screen.models.HomeScreenDataDto
import io.reactivex.Single
import javax.inject.Inject

class ExploreScreenDataDataSourceImpl @Inject constructor(
    private val homeMockApi: HomeMockApi
) : ExploreScreenDataDataSource {

    override fun getHomeScreenData(): Single<HomeScreenDataDto> {
        return homeMockApi.getHomeScreenData()
    }

}