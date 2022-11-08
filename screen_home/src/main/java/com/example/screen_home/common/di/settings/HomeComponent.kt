package com.example.screen_home.common.di.settings

import com.example.screen_home.common.di.modules.DataSourceModule
import com.example.screen_home.common.di.modules.InteractorModule
import com.example.screen_home.common.di.modules.RepositoryModule
import com.example.screen_home.common.di.modules.ViewModelModule
import com.example.screen_home.presentation.HomeFragment
import dagger.Component

@Component(
    modules = [
        InteractorModule::class,
        RepositoryModule::class,
        DataSourceModule::class,
        ViewModelModule::class,
    ],
    dependencies = [HomeDependencies::class],
)
interface HomeComponent {
    fun inject(fragment: HomeFragment)

    @Component.Factory
    interface Factory {
        fun create(dependency: HomeDependencies): HomeComponent
    }

}