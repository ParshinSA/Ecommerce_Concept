package com.example.screen_explore.common.di.modules

import com.example.screen_explore.domain.interactors.ExploreScreenInteractor
import com.example.screen_explore.domain.interactors.ExploreScreenInteractorImpl
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {

    @Provides
    fun provideExploreScreenInteractorImplToInterface(
        interactor: ExploreScreenInteractorImpl
    ): ExploreScreenInteractor {
        return interactor
    }

}