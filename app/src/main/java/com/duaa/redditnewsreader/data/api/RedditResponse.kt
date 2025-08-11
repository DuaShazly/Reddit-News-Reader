package com.duaa.redditnewsreader.data.api

data class RedditResponse(val data: RedditData)
data class RedditData(val children: List<RedditChildren>)
data class RedditChildren(val data: RedditPost)
data class RedditPost(
    val title: String,
    val thumbnail: String?,
    val url: String,
    val selftext: String?
)
