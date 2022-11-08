package com.example.screen_home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.screen_home.domain.interactors.HomeScreenInteractor
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val interactor: HomeScreenInteractor
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ViewModelHomeFrg::class.java) ->
                ViewModelHomeFrg(
                    interactor = interactor
                ) as T

            else -> error("Incorrect view model factory $modelClass")
        }
    }
}