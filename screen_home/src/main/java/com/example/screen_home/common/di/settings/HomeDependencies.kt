package com.example.screen_home.common.di.settings

import android.content.Context
import com.example.api_home_screen.api.HomeMockApi

interface HomeDependencies {
    val homeMockApi: HomeMockApi
    val context: Context
}