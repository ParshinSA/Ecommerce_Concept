package com.example.screen_home.common.di.modules

import androidx.lifecycle.ViewModel
import com.example.screen_home.presentation.viewmodels.ViewModelHomeFrg
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class ViewModelModule {
    @Provides
    @[IntoMap ClassKey(ViewModelHomeFrg::class)]
    fun bindViewModelHomeFrg(viewModel: ViewModelHomeFrg): ViewModel {
        return viewModel
    }
}