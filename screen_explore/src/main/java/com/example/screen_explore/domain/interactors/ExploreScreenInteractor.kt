package com.example.screen_explore.domain.interactors

import com.example.screen_explore.domain.models.ExploreScreenDataDomain
import io.reactivex.Single

interface ExploreScreenInteractor {
    fun getExploreScreenData(): Single<ExploreScreenDataDomain>
}