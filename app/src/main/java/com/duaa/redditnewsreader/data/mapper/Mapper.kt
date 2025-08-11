package com.duaa.redditnewsreader.data.mapper


import com.duaa.redditnewsreader.data.api.RedditResponse
import com.duaa.redditnewsreader.domain.model.Article

fun RedditResponse.toDomain(): List<Article> =
    data.children.map {
        Article(
            title = it.data.title,
            thumbnail = it.data.thumbnail.takeIf { thumb -> thumb?.startsWith("http") == true },
            url = it.data.url,
            selfText = it.data.selftext
        )
    }
