package com.example.api_home_screen.api

import com.example.api_home_screen.models.HomeScreenDataDto
import io.reactivex.Single
import retrofit2.http.GET

interface HomeMockApi {

    @GET("/v3/654bd15e-b121-49ba-a588-960956b15175")
    fun getHomeScreenData(): Single<HomeScreenDataDto>

}