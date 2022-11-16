package com.example.screen_explore.common.di.settings

import android.content.Context
import com.example.api_home_screen.api.HomeMockApi

interface ExploreDeps {
    val homeMockApi: HomeMockApi
    val context: Context
}