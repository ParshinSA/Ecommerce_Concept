package com.example.screen_explore.common.di.settings

import android.app.Application
import androidx.lifecycle.AndroidViewModel

internal class ExploreComponentViewModel(
    application: Application
) : AndroidViewModel(application) {

    internal val component = DaggerExploreComponent.factory()
        .create(ExploreDepsProvider.dependencies)

}