package com.example.ecommerceconcept.di

import android.content.Context
import com.example.ecommerceconcept.di.modules.DependenciesModule
import com.example.ecommerceconcept.di.settings.AppDependenciesProvider
import com.example.ecommerceconcept.di.settings.AppScope
import com.example.network.di.NetworkModule
import com.example.screen_home.common.di.settings.HomeDependencies
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@AppScope
@Singleton
@Component(
    modules = [
        DependenciesModule::class,
        NetworkModule::class,
    ]
)
interface AppComponent : AppDependenciesProvider {
    override val homeDependency: HomeDependencies

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder
        fun build(): AppComponent
    }

}