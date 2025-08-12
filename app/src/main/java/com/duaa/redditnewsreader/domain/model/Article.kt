package com.duaa.redditnewsreader.domain.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Serializable
data class Article(
    val title: String,
    val thumbnail: String?,
    val url: String,
    val selfText: String?
): Parcelable {
    override fun writeToParcel(dest: Parcel, flags: Int) {
        TODO("Not yet implemented")
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }
}
