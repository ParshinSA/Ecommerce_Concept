package com.example.navigation.settings

import com.example.container_fragment.di.dependencies.nested.FragmentRouterProvider
import com.github.terrakok.cicerone.Router
import javax.inject.Singleton

@Singleton
class FragmentRouterProviderImpl(override val router: Router) : FragmentRouterProvider