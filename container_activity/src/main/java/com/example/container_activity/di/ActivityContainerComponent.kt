package com.example.container_activity.di

import com.example.container_activity.AppActivity
import com.example.container_activity.di.dependencies.ActivityContainerDeps
import dagger.Component

@Component(dependencies = [ActivityContainerDeps::class])
interface ActivityContainerComponent {
    fun inject(activity: AppActivity)

    @Component.Factory
    interface Factory {
        fun create(dependencies: ActivityContainerDeps): ActivityContainerComponent
    }
}