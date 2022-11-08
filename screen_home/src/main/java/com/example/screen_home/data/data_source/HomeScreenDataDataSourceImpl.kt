package com.example.screen_home.data.data_source

import com.example.api_home_screen.api.HomeMockApi
import com.example.api_home_screen.models.HomeScreenDataDto
import io.reactivex.Single
import javax.inject.Inject

class HomeScreenDataDataSourceImpl @Inject constructor(
    private val homeMockApi: HomeMockApi
) : HomeScreenDataDataSource {

    override fun getHomeScreenData(): Single<HomeScreenDataDto> {
        return homeMockApi.getHomeScreenData()
    }

}