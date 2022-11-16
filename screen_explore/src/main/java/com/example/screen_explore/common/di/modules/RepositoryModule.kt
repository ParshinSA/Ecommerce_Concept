package com.example.screen_explore.common.di.modules

import com.example.screen_explore.data.repositories_impl.ExploreScreeRepositoryImpl
import com.example.screen_explore.domain.repositories.ExploreScreeRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideExploreScreeRepositoryImplToInterface(
        repository: ExploreScreeRepositoryImpl
    ): ExploreScreeRepository {
        return repository
    }

}