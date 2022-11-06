package com.example.ecommerceconcept.presentation

import android.app.Application
import com.example.ecommerceconcept.di.AppComponent
import com.example.ecommerceconcept.di.DaggerAppComponent

class AppApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .context(applicationContext)
            .build()
    }

}