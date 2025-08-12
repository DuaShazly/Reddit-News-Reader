package com.duaa.redditnewsreader.data.api

import retrofit2.http.GET

interface RedditApi {
    @GET("/r/Kotlin/.json")
    suspend fun getKotlinNews(): RedditResponse
}
