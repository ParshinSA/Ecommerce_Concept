package com.example.network.di

import com.example.api_home_screen.api.HomeMockApi
import com.example.api_my_cart_screen.api.MyCartMockApi
import com.example.api_product_details.api.ProductDetailsMockApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    fun provideHomeMockApi(retrofit: Retrofit): HomeMockApi {
        return retrofit.newBuilder()
            .baseUrl(HOME_MOCK_API_URL)
            .build()
            .create()
    }

    @Provides
    fun provideMyCartMockApi(retrofit: Retrofit): MyCartMockApi {
        return retrofit.newBuilder()
            .baseUrl(MY_CART_MOCK_API_URL)
            .build()
            .create()
    }

    @Provides
    fun provideProductDetailsMockApi(retrofit: Retrofit): ProductDetailsMockApi {
        return retrofit.newBuilder()
            .baseUrl(PRODUCT_DETAILS_MOCK_API_URL)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    companion object {
        internal const val PRODUCT_DETAILS_MOCK_API_URL = "https://run.mocky.io/"
        internal const val MY_CART_MOCK_API_URL = "https://run.mocky.io/"
        internal const val HOME_MOCK_API_URL = "https://run.mocky.io/"
        internal const val BASE_URL = "https://run.mocky.io/"
    }

}