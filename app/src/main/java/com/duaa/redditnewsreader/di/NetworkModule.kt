package com.duaa.redditnewsreader.di

import com.duaa.redditnewsreader.data.api.RedditApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides @Singleton fun provideJson(): Json = Json { ignoreUnknownKeys = true }
    @Provides @Singleton fun provideRetrofit(json: Json): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://www.reddit.com/")
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    @Provides @Singleton fun provideApi(retrofit: Retrofit): RedditApi = retrofit.create(RedditApi::class.java)
}
