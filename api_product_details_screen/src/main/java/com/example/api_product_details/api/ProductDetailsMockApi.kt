package com.example.api_product_details.api

import com.example.api_product_details.models.ProductDetailsDto
import io.reactivex.Single
import retrofit2.http.GET

interface ProductDetailsMockApi {

    @GET("v3/6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    fun getHomeScreenData(): Single<ProductDetailsDto>

}