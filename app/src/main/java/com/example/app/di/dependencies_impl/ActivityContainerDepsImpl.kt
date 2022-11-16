package com.example.app.di.dependencies_impl

import com.example.container_activity.di.dependencies.nested.ActivityRouterProvider
import com.example.container_activity.di.dependencies.nested.ScreensContainerActivity
import com.example.container_activity.di.dependencies.ActivityContainerDeps
import com.github.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

class ActivityContainerDepsImpl @Inject constructor(
    override val screensContainerActivity: ScreensContainerActivity,
    override val activityRouterProvider: ActivityRouterProvider,
    override val navigatorHolder: NavigatorHolder,
) : ActivityContainerDeps