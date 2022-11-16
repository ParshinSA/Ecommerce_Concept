package com.example.app

import android.app.Application
import com.example.container_activity.di.dependencies.ActivityContainerDepsProvider
import com.example.container_fragment.di.dependencies.FragmentContainerDepsProvider
import com.example.app.di.AppComponent
import com.example.app.di.DaggerAppComponent
import com.example.screen_explore.common.di.settings.ExploreDepsProvider

class AppApplication : Application() {

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .context(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        dependenciesProvide()
    }

    private fun dependenciesProvide() {
        ExploreDepsProvider.dependencies = appComponent.exploreDeps
        ActivityContainerDepsProvider.dependencies = appComponent.activityContainerDeps
        FragmentContainerDepsProvider.dependencies = appComponent.fragmentContainerDeps
    }
}