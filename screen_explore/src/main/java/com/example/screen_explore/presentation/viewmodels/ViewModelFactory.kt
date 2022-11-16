package com.example.screen_explore.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.screen_explore.domain.interactors.ExploreScreenInteractor
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val interactor: ExploreScreenInteractor
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ViewModelExploreFrg::class.java) ->
                ViewModelExploreFrg(
                    interactor = interactor
                ) as T

            else -> error("Incorrect view model factory $modelClass")
        }
    }
}