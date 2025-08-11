package com.duaa.redditnewsreader.data.cache

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.duaa.redditnewsreader.domain.model.Article
import kotlinx.coroutines.flow.first
import kotlinx.serialization.json.Json

val Context.dataStore by preferencesDataStore(name = "articles")
class ArticleCache(private val context: Context) {
    private val key = stringPreferencesKey("article_list")
    suspend fun save(articles: List<Article>) {
        val json = Json.encodeToString(articles)
        context.dataStore.edit { it[key] = json }
    }
    suspend fun load(): List<Article> {
        val json = context.dataStore.data.first()[key] ?: return emptyList()
        return runCatching { Json.decodeFromString<List<Article>>(json) }.getOrDefault(emptyList())
    }
}
