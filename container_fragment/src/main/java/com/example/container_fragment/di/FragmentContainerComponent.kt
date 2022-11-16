package com.example.container_fragment.di

import com.example.container_fragment.di.dependencies.FragmentContainerDeps
import com.example.container_fragment.presentation.ContainerFragment
import dagger.Component

@Component(dependencies = [FragmentContainerDeps::class])
interface FragmentContainerComponent {
    fun inject(fragment: ContainerFragment)

    @Component.Factory
    interface Factory {
        fun create(dependencies: FragmentContainerDeps): FragmentContainerComponent
    }
}