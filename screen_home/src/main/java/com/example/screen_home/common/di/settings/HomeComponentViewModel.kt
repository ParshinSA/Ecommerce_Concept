package com.example.screen_home.common.di.settings

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class HomeComponentViewModel(application: Application) : AndroidViewModel(application) {

    internal val component = DaggerHomeComponent.factory()
        .create(HomeDependencyProvider.dependency)

}