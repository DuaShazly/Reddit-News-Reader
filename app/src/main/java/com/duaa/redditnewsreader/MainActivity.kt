package com.duaa.redditnewsreader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import com.duaa.redditnewsreader.presentation.navigation.AppNavigation
import com.duaa.redditnewsreader.presentation.viewmodel.NewsViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Greeting()
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val vm: NewsViewModel = hiltViewModel()
    AppNavigation(vm)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Greeting()
}