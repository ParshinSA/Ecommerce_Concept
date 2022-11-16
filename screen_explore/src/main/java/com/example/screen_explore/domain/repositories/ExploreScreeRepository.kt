package com.example.screen_explore.domain.repositories

import com.example.screen_explore.domain.models.ExploreScreenDataDomain
import io.reactivex.Single

interface ExploreScreeRepository {
    fun getExploreScreenData(): Single<ExploreScreenDataDomain>
}