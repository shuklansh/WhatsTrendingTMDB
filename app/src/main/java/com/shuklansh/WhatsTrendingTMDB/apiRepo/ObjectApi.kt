package com.shuklansh.WhatsTrendingTMDB.apiRepo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ObjectApi {

    val BASE_URL = "https://api.themoviedb.org/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

}