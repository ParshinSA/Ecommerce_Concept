package com.example.navigation.settings

import com.example.container_activity.di.dependencies.nested.ActivityRouterProvider
import com.github.terrakok.cicerone.Router
import javax.inject.Singleton

@Singleton
class ActivityRouterProviderImpl(override val router: Router) : ActivityRouterProvider