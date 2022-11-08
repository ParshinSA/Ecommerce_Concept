package com.example.screen_home.common.di.modules

import com.example.screen_home.data.data_source.HomeScreenDataDataSource
import com.example.screen_home.data.data_source.HomeScreenDataDataSourceImpl
import dagger.Module
import dagger.Provides

@Module
class DataSourceModule {

    @Provides
    fun provideHomeScreenDataDataSourceImplToInterface(
        dataSource: HomeScreenDataDataSourceImpl
    ): HomeScreenDataDataSource {
        return dataSource
    }

}