package com.example.navigation

import com.example.container_activity.di.dependencies.nested.ActivityRouterProvider
import com.example.container_activity.di.dependencies.nested.ScreensContainerActivity
import com.example.container_fragment.di.dependencies.nested.FragmentRouterProvider
import com.example.container_fragment.di.dependencies.nested.ScreensContainerFragment
import com.example.navigation.settings.ActivityRouterProviderImpl
import com.example.navigation.settings.FragmentRouterProviderImpl
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NavigationModule {
    private val cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    @Singleton
    fun provideRouterAppActivity(): ActivityRouterProvider {
        return ActivityRouterProviderImpl(cicerone.router)
    }

    @Provides
    @Singleton
    fun provideRouterContainerFrg(): FragmentRouterProvider {
        return FragmentRouterProviderImpl(cicerone.router)
    }

    @Provides
    @Singleton
    fun provideNavigatorHolder(): NavigatorHolder {
        return cicerone.getNavigatorHolder()
    }

    @Provides
    @Singleton
    fun provideScreensContainerActivity(): ScreensContainerActivity {
        return Screens
    }

    @Provides
    @Singleton
    fun provideScreensContainerFragment(): ScreensContainerFragment {
        return Screens
    }
}