package com.duaa.redditnewsreader.domain.repository
import com.duaa.redditnewsreader.domain.model.Article
import com.duaa.redditnewsreader.utils.Resource
import kotlinx.coroutines.flow.Flow


interface NewsRepository { fun getArticles(): Flow<Resource<List<Article>>> }
