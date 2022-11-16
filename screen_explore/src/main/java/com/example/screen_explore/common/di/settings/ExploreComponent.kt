package com.example.screen_explore.common.di.settings

import com.example.screen_explore.common.di.modules.DataSourceModule
import com.example.screen_explore.common.di.modules.InteractorModule
import com.example.screen_explore.common.di.modules.RepositoryModule
import com.example.screen_explore.common.di.modules.ViewModelModule
import com.example.screen_explore.presentation.fragments.ExploreFragment
import dagger.Component

@Component(
    modules = [
        InteractorModule::class,
        RepositoryModule::class,
        DataSourceModule::class,
        ViewModelModule::class,
    ],
    dependencies = [ExploreDeps::class],
)
interface ExploreComponent {
    fun inject(fragment: ExploreFragment)

    @Component.Factory
    interface Factory {
        fun create(dependency: ExploreDeps): ExploreComponent
    }

}