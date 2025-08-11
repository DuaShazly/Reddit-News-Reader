package com.duaa.redditnewsreader.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.duaa.redditnewsreader.domain.model.Article
import com.duaa.redditnewsreader.presentation.ui.ArticleDetailScreen
import com.duaa.redditnewsreader.presentation.ui.NewsListScreen
import com.duaa.redditnewsreader.presentation.viewmodel.NewsViewModel

@Composable
fun AppNavigation(viewModel: NewsViewModel) {
    val navController: NavHostController = rememberNavController()
    val state = viewModel.state.collectAsState().value

    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            NewsListScreen(state = state) { article ->
                navController.currentBackStackEntry?.savedStateHandle?.set("article", article)
                navController.navigate("detail")
            }
        }
        composable("detail") {
            val article = navController.previousBackStackEntry?.savedStateHandle?.get<Article>("article")
            article?.let {
                ArticleDetailScreen(article = it) { navController.popBackStack() }
            }
        }
    }
}
