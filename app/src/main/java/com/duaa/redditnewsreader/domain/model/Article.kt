package com.duaa.redditnewsreader.domain.model

data class Article(
    val title: String,
    val thumbnail: String?,
    val url: String,
    val selfText: String?
)
