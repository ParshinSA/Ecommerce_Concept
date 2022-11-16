package com.example.screen_explore.common.di.modules

import com.example.screen_explore.data.data_source.ExploreScreenDataDataSource
import com.example.screen_explore.data.data_source.ExploreScreenDataDataSourceImpl
import dagger.Module
import dagger.Provides

@Module
class DataSourceModule {

    @Provides
    fun provideExploreScreenDataDataSourceImplToInterface(
        dataSource: ExploreScreenDataDataSourceImpl
    ): ExploreScreenDataDataSource {
        return dataSource
    }

}