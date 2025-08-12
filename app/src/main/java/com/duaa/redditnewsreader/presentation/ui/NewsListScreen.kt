package com.duaa.redditnewsreader.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.duaa.redditnewsreader.R
import com.duaa.redditnewsreader.domain.model.Article
import com.duaa.redditnewsreader.presentation.viewmodel.NewsListState

@Composable
fun NewsListScreen(state: NewsListState, onClick: (Article) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(state.articles) { article ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { onClick(article) },
                elevation = CardDefaults.cardElevation()
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    article.thumbnail?.let {
                        AsyncImage(
                            model = it,
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                        )
                    }.run {
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp),
                            painter = painterResource(id = R.drawable.reddit_logo),
                            contentDescription = "My image",
                            contentScale = ContentScale.Crop
                        )
                    }
                    Text(text = article.title,fontSize=14.sp, fontWeight = FontWeight.Bold,  modifier = Modifier.padding(top = 16.dp))
                }
            }
        }
    }
}
