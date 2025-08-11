package com.duaa.redditnewsreader.data.repository
import com.duaa.redditnewsreader.data.cache.ArticleCache
import com.duaa.redditnewsreader.data.api.RedditApi
import com.duaa.redditnewsreader.data.mapper.toDomain
import com.duaa.redditnewsreader.domain.model.Article
import com.duaa.redditnewsreader.domain.repository.NewsRepository
import com.duaa.redditnewsreader.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
class NewsRepositoryImpl(private val api:RedditApi, private val cache:ArticleCache): NewsRepository {
    override fun getArticles(): Flow<Resource<List<Article>>> = flow {
        emit(Resource.Loading())
        try { val remote = api.getKotlinNews().toDomain(); cache.save(remote); emit(Resource.Success(remote)) }
        catch (e: Exception) { val local = cache.load(); if (local.isNotEmpty()) emit(Resource.Success(local)) else emit(Resource.Error("Unable to fetch articles.")) }
    }
}
