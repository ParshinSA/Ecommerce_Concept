package com.example.screen_home.presentation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.screen_home.common.di.settings.HomeComponentViewModel
import javax.inject.Inject

class HomeFragment : Fragment() {

    private val component: HomeComponentViewModel by viewModels()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: ViewModelHomeFrg by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun inject() {
        component.component.inject(this)
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}