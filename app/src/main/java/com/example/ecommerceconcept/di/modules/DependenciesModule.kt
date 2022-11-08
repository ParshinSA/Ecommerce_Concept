package com.example.ecommerceconcept.di.modules

import com.example.ecommerceconcept.di.dependencies_impl.HomeDependenciesImpl
import com.example.screen_home.common.di.settings.HomeDependencies
import dagger.Module
import dagger.Provides

@Module
class DependenciesModule {

    @Provides
    fun homeDependenciesImplToInterface(
        homeDependencies: HomeDependenciesImpl
    ): HomeDependencies {
        return homeDependencies
    }

}