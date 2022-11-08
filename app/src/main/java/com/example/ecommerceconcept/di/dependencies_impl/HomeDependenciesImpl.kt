package com.example.ecommerceconcept.di.dependencies_impl

import android.content.Context
import com.example.api_home_screen.api.HomeMockApi
import com.example.ecommerceconcept.di.settings.AppScope
import com.example.screen_home.common.di.settings.HomeDependencies
import javax.inject.Inject

@AppScope
class HomeDependenciesImpl @Inject constructor(
    override val homeMockApi: HomeMockApi,
    override val context: Context,
) : HomeDependencies