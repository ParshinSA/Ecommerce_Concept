package com.example.screen_explore.data.data_source

import com.example.api_home_screen.models.HomeScreenDataDto
import io.reactivex.Single

interface ExploreScreenDataDataSource {

    fun getHomeScreenData(): Single<HomeScreenDataDto>

}