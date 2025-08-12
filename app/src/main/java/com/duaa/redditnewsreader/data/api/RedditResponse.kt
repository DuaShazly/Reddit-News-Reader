package com.duaa.redditnewsreader.data.api

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class RedditResponse(val data: RedditData)

@Serializable
data class RedditData(val children: List<RedditChildren>)

@Serializable
data class RedditChildren(val data: RedditPost)

@Serializable
data class RedditPost(
    @field:SerializedName("title")
    @Expose
    val title: String,
    @field:SerializedName("thumbnail")
    @Expose
    val thumbnail: String?,
    @field:SerializedName("url")
    @Expose
    val url: String,
    @field:SerializedName("selftext")
    @Expose
    val selftext: String?,
    @field:SerializedName("selftext_html")
    @Expose
    val selftext_html: String?
)
