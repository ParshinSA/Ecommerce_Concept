package com.example.app.di.modules

import com.example.container_activity.di.dependencies.ActivityContainerDeps
import com.example.container_fragment.di.dependencies.FragmentContainerDeps
import com.example.app.di.dependencies_impl.ActivityContainerDepsImpl
import com.example.app.di.dependencies_impl.ExploreDepsImpl
import com.example.app.di.dependencies_impl.FragmentContainerDepsImpl
import com.example.screen_explore.common.di.settings.ExploreDeps
import dagger.Module
import dagger.Provides

@Module
class DependenciesModule {

    @Provides
    fun exploreDepsImplToInterface(dependencies: ExploreDepsImpl): ExploreDeps {
        return dependencies
    }

    @Provides
    fun activityContainerDepsImplToInterface(dependencies: ActivityContainerDepsImpl): ActivityContainerDeps {
        return dependencies
    }

    @Provides
    fun fragmentContainerDepsImplToInterface(dependencies: FragmentContainerDepsImpl): FragmentContainerDeps {
        return dependencies
    }
}