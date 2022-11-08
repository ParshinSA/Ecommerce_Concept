package com.example.ecommerceconcept.di.settings

import com.example.screen_home.common.di.settings.HomeDependencies

@AppScope
interface AppDependenciesProvider {
    val homeDependency: HomeDependencies
}