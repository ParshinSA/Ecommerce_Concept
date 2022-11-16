package com.example.app.di.dependencies_impl

import android.content.Context
import com.example.api_home_screen.api.HomeMockApi
import com.example.app.di.settings.AppScope
import com.example.screen_explore.common.di.settings.ExploreDeps
import javax.inject.Inject

@AppScope
class ExploreDepsImpl @Inject constructor(
    override val homeMockApi: HomeMockApi,
    override val context: Context,
) : ExploreDeps