package com.example.screen_home.common.di.modules

import com.example.screen_home.data.repositories_impl.HomeScreeRepositoryImpl
import com.example.screen_home.domain.repositories.HomeScreeRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideHomeScreeRepositoryImplToInterface(
        repository: HomeScreeRepositoryImpl
    ): HomeScreeRepository {
        return repository
    }

}