package com.example.container_activity.di

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.container_activity.di.dependencies.ActivityContainerDepsProvider

class ActivityContainerComponentViewModel(
    application: Application
) : AndroidViewModel(application) {

    internal val component = DaggerActivityContainerComponent.factory()
        .create(ActivityContainerDepsProvider.dependencies)

}