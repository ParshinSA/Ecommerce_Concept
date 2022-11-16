package com.example.container_fragment.di

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.container_fragment.di.dependencies.FragmentContainerDepsProvider

class FragmentContainerComponentViewModel(
    application: Application
) : AndroidViewModel(application) {

    val component = DaggerFragmentContainerComponent.factory()
        .create(FragmentContainerDepsProvider.dependencies)
}