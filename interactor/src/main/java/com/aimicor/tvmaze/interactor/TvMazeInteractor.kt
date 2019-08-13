package com.aimicor.tvmaze.interactor

import com.aimicor.tvmaze.ApiService
import com.aimicor.tvmaze.ApiServiceFactory
import io.reactivex.Single

class TvMazeInteractor {

    private val apiService: ApiService = ApiServiceFactory().create()

    val listOfShowsObservable: Single<List<TvMazeItemSummary>> by lazy {
        apiService
            .getSchedule()
            .toObservable()
            .flatMapIterable { it }
            .map {
                TvMazeItemSummary(
                    itemName = it.show.name,
                    itemEpisodeName = it.name,
                    itemImageUrl = it.show.image.medium
                )
            }
            .toList()
    }
}