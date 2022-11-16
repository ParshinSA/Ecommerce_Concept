package com.example.app.di

import android.content.Context
import com.example.container_activity.di.dependencies.ActivityContainerDeps
import com.example.container_fragment.di.dependencies.FragmentContainerDeps
import com.example.app.di.modules.DependenciesModule
import com.example.app.di.settings.AppDependenciesProvider
import com.example.app.di.settings.AppScope
import com.example.navigation.NavigationModule
import com.example.network.di.NetworkModule
import com.example.screen_explore.common.di.settings.ExploreDeps
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@AppScope
@Singleton
@Component(
    modules = [
        DependenciesModule::class,
        NavigationModule::class,
        NetworkModule::class,
    ]
)
interface AppComponent : AppDependenciesProvider {
    override val fragmentContainerDeps: FragmentContainerDeps
    override val activityContainerDeps: ActivityContainerDeps
    override val exploreDeps: ExploreDeps

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder
        fun build(): AppComponent
    }

}