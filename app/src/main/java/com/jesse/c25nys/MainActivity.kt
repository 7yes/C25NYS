package com.jesse.c25nys

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jesse.c25nys.presentation.details.DetailsScreen
import com.jesse.c25nys.presentation.home.HomeScreen
import com.jesse.c25nys.ui.theme.C25NYSTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            C25NYSTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    InitialScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun InitialScreen(modifier: Modifier) {
    val navController = rememberNavController()
    lateinit var dbn: String
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(modifier)
            {
                dbn = it
                navController.navigate("details")
            }
        }
        composable("details") {
            DetailsScreen(modifier, dbn)
        }
    }
}




