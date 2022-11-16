package com.example.container_fragment.di.dependencies

import com.example.container_fragment.di.dependencies.nested.FragmentRouterProvider
import com.example.container_fragment.di.dependencies.nested.ScreensContainerFragment
import com.github.terrakok.cicerone.NavigatorHolder

interface FragmentContainerDeps {
    val screensContainerFragment: ScreensContainerFragment
    val fragmentRouterProvider: FragmentRouterProvider
    val navigatorHolder: NavigatorHolder
}