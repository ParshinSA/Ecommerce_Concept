package com.example.screen_explore.domain.interactors

import com.example.screen_explore.domain.models.ExploreScreenDataDomain
import com.example.screen_explore.domain.repositories.ExploreScreeRepository
import io.reactivex.Single
import javax.inject.Inject

class ExploreScreenInteractorImpl @Inject constructor(
    private val exploreScreeRepository: ExploreScreeRepository
) : ExploreScreenInteractor {

    override fun getExploreScreenData(): Single<ExploreScreenDataDomain> {
        return exploreScreeRepository.getExploreScreenData()
    }

}