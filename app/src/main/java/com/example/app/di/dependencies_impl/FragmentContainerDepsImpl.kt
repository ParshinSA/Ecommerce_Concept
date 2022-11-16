package com.example.app.di.dependencies_impl

import com.example.container_fragment.di.dependencies.FragmentContainerDeps
import com.example.container_fragment.di.dependencies.nested.FragmentRouterProvider
import com.example.container_fragment.di.dependencies.nested.ScreensContainerFragment
import com.github.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

class FragmentContainerDepsImpl @Inject constructor(
    override val screensContainerFragment: ScreensContainerFragment,
    override val fragmentRouterProvider: FragmentRouterProvider,
    override val navigatorHolder: NavigatorHolder
) : FragmentContainerDeps