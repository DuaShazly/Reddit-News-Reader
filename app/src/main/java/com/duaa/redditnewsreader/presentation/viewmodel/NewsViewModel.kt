package com.duaa.redditnewsreader.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duaa.redditnewsreader.domain.model.Article
import com.duaa.redditnewsreader.domain.usecase.GetKotlinNewsUseCase
import com.duaa.redditnewsreader.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class NewsListState(
    val articles: List<Article> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)

class NewsViewModel(private val useCase: GetKotlinNewsUseCase) : ViewModel() {
    private val _state = MutableStateFlow(NewsListState())
    val state: StateFlow<NewsListState> = _state

    init {
        getArticles()
    }

    fun getArticles() {
        viewModelScope.launch {
            useCase().collect { result ->
                _state.value = when (result) {
                    is Resource.Success -> NewsListState(articles = result.data ?: emptyList())
                    is Resource.Error -> NewsListState(error = result.message ?: "Unknown error")
                    is Resource.Loading -> NewsListState(isLoading = true)
                }
            }
        }
    }
}
