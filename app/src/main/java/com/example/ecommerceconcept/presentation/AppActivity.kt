package com.example.ecommerceconcept.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.databinding.ActivityAppBinding
import com.example.screen_home.presentation.fragments.HomeFragment

class AppActivity : AppCompatActivity() {

    private var _binding: ActivityAppBinding? = null
    private val binding get() = checkNotNull(_binding)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startFragment()
    }

    private fun startFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.activityContainerFragment, HomeFragment.newInstance())
            .commit()
    }

}