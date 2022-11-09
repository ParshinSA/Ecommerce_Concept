package com.example.screen_home.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.screen_home.common.di.settings.HomeComponentViewModel
import com.example.screen_home.databinding.FragmentHome2Binding
import com.example.screen_home.presentation.viewmodels.ViewModelFactory
import com.example.screen_home.presentation.viewmodels.ViewModelHomeFrg
import javax.inject.Inject

class HomeFragment : Fragment() {

    private var _binding: FragmentHome2Binding? = null
    private val binding get() = checkNotNull(_binding)

    private val component: HomeComponentViewModel by viewModels()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: ViewModelHomeFrg by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHome2Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    private fun inject() {
        component.component.inject(this)
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}