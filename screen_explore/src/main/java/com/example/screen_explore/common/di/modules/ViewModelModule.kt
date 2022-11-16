package com.example.screen_explore.common.di.modules

import androidx.lifecycle.ViewModel
import com.example.screen_explore.presentation.viewmodels.ViewModelExploreFrg
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class ViewModelModule {
    @Provides
    @[IntoMap ClassKey(ViewModelExploreFrg::class)]
    fun bindViewModelExploreFrg(viewModel: ViewModelExploreFrg): ViewModel {
        return viewModel
    }
}