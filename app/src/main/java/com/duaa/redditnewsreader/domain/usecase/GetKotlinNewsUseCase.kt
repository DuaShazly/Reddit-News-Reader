package com.duaa.redditnewsreader.domain.usecase

import com.duaa.redditnewsreader.domain.model.Article
import com.duaa.redditnewsreader.domain.repository.NewsRepository
import com.duaa.redditnewsreader.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetKotlinNewsUseCase(private val repository: NewsRepository) {
    operator fun invoke(): Flow<Resource<List<Article>>> = repository.getArticles()
}