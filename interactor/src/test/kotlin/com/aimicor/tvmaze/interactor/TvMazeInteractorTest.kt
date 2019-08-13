package com.aimicor.tvmaze.interactor

import com.aimicor.tvmaze.ApiService
import com.aimicor.tvmaze.model.*
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Assert.assertEquals
import org.junit.Test

class TvMazeInteractorTest {

    private val apiService = mock<ApiService>()
    private val subject = TvMazeInteractor()

    @Test
    fun `can get list of shows`() {
        val itemName1 = "show1"
        val episodeName1 = "episodeName1"
        val imageUrl1 = "image1"
        val itemName2 = "show2"
        val episodeName2 = "episodeName2"
        val imageUrl2 = "image2"
        whenever(apiService.getSchedule()).thenReturn(
            Single.just(listOf(
                createTvMaze(itemName1, episodeName1, imageUrl1),
                createTvMaze(itemName2, episodeName2, imageUrl2)
            ))
        )

        val listOfShowsObserver = subject.listOfShowsObservable.test()

        listOfShowsObserver.assertValueCount(1)
        val resultList = listOfShowsObserver.values()[0]
        assertEquals(itemName1, resultList[0].itemName)
        assertEquals(episodeName1, resultList[0].itemEpisodeName)
        assertEquals(imageUrl1, resultList[0].itemImageUrl)
        assertEquals(itemName2, resultList[1].itemName)
        assertEquals(episodeName2, resultList[1].itemEpisodeName)
        assertEquals(imageUrl2, resultList[1].itemImageUrl)
    }

    private fun createTvMaze(itemName: String, episodeName: String, imageUrl: String) =
        TvMaze(
            airtime = "",
            airstamp = "",
            airdate = "",
            season = 0,
            runtime = 0,
            number = 0,
            name = episodeName,
            id = 0,
            url = "",
            links = Links(
                self = Href(
                    href = ""
                ),
                nextepisode = null,
                previousepisode = null
            ),
            show = Show(
                id = 0,
                url = "",
                name = itemName,
                runtime = 0,
                genres = listOf(),
                language = "",
                officialSite = "",
                premiered = "",
                status = "",
                summary = "",
                type = "",
                updated = 0,
                weight = 0,
                links = Links(
                    self = Href(
                        href = ""
                    ),
                    nextepisode = null,
                    previousepisode = null
                ),
                webChannel = null,
                image = Image(
                    medium = imageUrl,
                    original = ""
                ),
                externals = Externals(
                    imdb = "",
                    tvrage = 0,
                    thetvdb = 0
                ),
                network = Network(
                    name = "",
                    id = 0,
                    country = Country(
                        code = "",
                        name = "",
                        timezone = ""
                    )
                ),
                rating = Rating(
                    average = 0.0
                ),
                schedule = Schedule(
                    days = emptyList(),
                    time = ""
                )
            ),
            image = null,
            summary = null
        )

}