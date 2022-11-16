package com.example.screen_explore.data.repositories_impl

import android.util.Log
import com.example.screen_explore.data.data_source.ExploreScreenDataDataSource
import com.example.screen_explore.data.dto_to_domain.toHomeScreenDataDomain
import com.example.screen_explore.domain.models.ExploreScreenDataDomain
import com.example.screen_explore.domain.repositories.ExploreScreeRepository
import io.reactivex.Single
import javax.inject.Inject

class ExploreScreeRepositoryImpl @Inject constructor(
    private val dataSource: ExploreScreenDataDataSource
) : ExploreScreeRepository {

    override fun getExploreScreenData(): Single<ExploreScreenDataDomain> {
        return dataSource.getHomeScreenData()
            .map { homeScreenDataDto ->
                Log.d("MyTAG", "observeData: $homeScreenDataDto")
                homeScreenDataDto.toHomeScreenDataDomain()
            }
    }

}