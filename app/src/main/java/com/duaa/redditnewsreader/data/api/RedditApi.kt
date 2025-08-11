package com.duaa.redditnewsreader.data.api

import retrofit2.http.GET

interface RedditApi {
    @GET("/r/kotlin/.json")
    suspend fun getKotlinNews(): RedditResponse
}
