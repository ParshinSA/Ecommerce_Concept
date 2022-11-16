@file:Suppress("FunctionName")

package com.example.navigation

import com.example.container_activity.di.dependencies.nested.ScreensContainerActivity
import com.example.container_fragment.di.dependencies.nested.ScreensContainerFragment
import com.example.container_fragment.presentation.ContainerFragment
import com.example.screen_explore.presentation.fragments.ExploreFragment
import com.example.screen_my_cart.presentation.MyCartFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens : ScreensContainerFragment, ScreensContainerActivity {

    override fun ContainerFrgNavMenu() = FragmentScreen {
        ContainerFragment.newInstance()
    }

    override fun ExploreFrg() = FragmentScreen {
        ExploreFragment.newInstance()
    }

    override fun MyCartFrg() = FragmentScreen {
        MyCartFragment.newInstance()
    }

}