package com.shuklansh.practicejc.apiRepo

import com.shuklansh.tmdblist.model.TrendingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface InterfaceApi {

    @GET("3/trending/all/day")
    suspend fun getTrending(@Query("api_key") apikey : String) : TrendingResponse

    @GET("3/trending/all/day")
    suspend fun checkInterNet(@Query("api_key") apikey : String) : Response<TrendingResponse>

}