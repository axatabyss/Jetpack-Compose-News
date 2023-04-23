package com.axat.newscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.axat.newscompose.presentation.screens.HomeScreen
import com.axat.newscompose.presentation.screens.NewsScreen
import com.axat.newscompose.ui.theme.NewsComposeTheme
import com.axat.newscompose.utils.Destination
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Destination.HomeScreen.route) {
                        composable(Destination.HomeScreen.route) { HomeScreen(navController) }
                        composable(Destination.NewsScreen.route) { NewsScreen(navController) }
                    }

                }
            }
        }
    }
}