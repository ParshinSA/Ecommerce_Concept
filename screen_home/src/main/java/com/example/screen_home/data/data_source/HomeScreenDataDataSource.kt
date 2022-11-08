package com.example.screen_home.data.data_source

import com.example.api_home_screen.models.HomeScreenDataDto
import io.reactivex.Single

interface HomeScreenDataDataSource {

    fun getHomeScreenData(): Single<HomeScreenDataDto>

}