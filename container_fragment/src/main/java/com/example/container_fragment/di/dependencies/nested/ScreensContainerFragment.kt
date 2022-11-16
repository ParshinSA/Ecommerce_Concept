@file:Suppress("FunctionName")

package com.example.container_fragment.di.dependencies.nested

import com.github.terrakok.cicerone.androidx.FragmentScreen

interface ScreensContainerFragment {
    fun ExploreFrg(): FragmentScreen
    fun MyCartFrg(): FragmentScreen
}