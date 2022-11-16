package com.example.app.di.settings

import com.example.container_activity.di.dependencies.ActivityContainerDeps
import com.example.container_fragment.di.dependencies.FragmentContainerDeps
import com.example.screen_explore.common.di.settings.ExploreDeps

@AppScope
interface AppDependenciesProvider {
    val exploreDeps: ExploreDeps
    val activityContainerDeps: ActivityContainerDeps
    val fragmentContainerDeps: FragmentContainerDeps
}