package com.example.screen_home.common.di.modules

import com.example.screen_home.domain.interactors.HomeScreenInteractor
import com.example.screen_home.domain.interactors.HomeScreenInteractorImpl
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {

    @Provides
    fun provideHomeScreenInteractorImplToInterface(
        interactor: HomeScreenInteractorImpl
    ): HomeScreenInteractor {
        return interactor
    }

}