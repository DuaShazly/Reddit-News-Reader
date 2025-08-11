package com.duaa.redditnewsreader.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.duaa.redditnewsreader.domain.model.Article

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleDetailScreen(article: Article, onBack: () -> Unit) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(article.title, maxLines = 1, overflow = TextOverflow.Ellipsis) },
            navigationIcon = {
                IconButton(onClick = onBack) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }
        )
    }) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            article.thumbnail?.let {
                AsyncImage(
                    model = it,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Spacer(modifier = Modifier.height(12.dp))
            }
            Text(text = article.selfText ?: "No content available.")
        }
    }
}
