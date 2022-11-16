package com.example.container_activity.di.dependencies.nested

import com.github.terrakok.cicerone.Router

interface ActivityRouterProvider {
    val router: Router
}