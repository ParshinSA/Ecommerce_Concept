package com.example.api_my_cart_screen.api

import com.example.api_my_cart_screen.models.MyCartScreenDataDto
import io.reactivex.Single
import retrofit2.http.GET

interface MyCartMockApi {

    @GET("v3/53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    fun getMyCartData(): Single<MyCartScreenDataDto>

}