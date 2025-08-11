package com.duaa.redditnewsreader.di

import android.app.Application
import com.duaa.redditnewsreader.data.cache.ArticleCache
import com.duaa.redditnewsreader.data.api.RedditApi
import com.duaa.redditnewsreader.domain.usecase.GetKotlinNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides @Singleton fun provideCache(app: Application) = ArticleCache(app)
    @Provides @Singleton fun provideRepo(api: RedditApi, cache: ArticleCache): NewsRepository = NewsRepositoryImpl(api, cache)
    @Provides @Singleton fun provideUseCase(repo: NewsRepository) = GetKotlinNewsUseCase(repo)
}
