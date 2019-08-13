package com.aimicor.tvmaze

import com.aimicor.tvmaze.model.TvMaze
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("schedule")
    fun getSchedule(): Single<List<TvMaze>>

//    @GET("schedule /{id}.json")
//    fun getItem(@Path("id") id: Int): Single<TvMaze>


//        @GET("people/{id}")
//        fun getPerson() : TvMaze
//
//        @GET("search/people")
//        fun searchPeople() : TvMaze
//
//        @GET("search/shows")
//        fun searchShows() : TvMaze

}