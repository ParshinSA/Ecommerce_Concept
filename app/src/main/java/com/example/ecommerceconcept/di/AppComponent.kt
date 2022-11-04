package com.example.ecommerceconcept.di

import android.content.Context
import com.example.network.di.NetworkModule
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
    modules = [
        NetworkModule::class,
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder
        fun build(): AppComponent
    }
}