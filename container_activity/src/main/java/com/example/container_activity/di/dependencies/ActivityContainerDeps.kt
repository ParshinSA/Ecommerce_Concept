package com.example.container_activity.di.dependencies

import com.example.container_activity.di.dependencies.nested.ActivityRouterProvider
import com.example.container_activity.di.dependencies.nested.ScreensContainerActivity
import com.github.terrakok.cicerone.NavigatorHolder

interface ActivityContainerDeps {
    val activityRouterProvider: ActivityRouterProvider
    val navigatorHolder: NavigatorHolder
    val screensContainerActivity: ScreensContainerActivity
}