package com.example.ecommerceconcept.presentation

import android.app.Application
import com.example.ecommerceconcept.di.AppComponent
import com.example.ecommerceconcept.di.DaggerAppComponent
import com.example.screen_home.common.di.settings.HomeDependencyProvider

class AppApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .context(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        dependenciesProvide()
    }

    private fun dependenciesProvide() {
        HomeDependencyProvider.dependency = appComponent.homeDependency
    }
}