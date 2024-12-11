package com.jesse.c25nys

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jesse.c25nys.presentation.HomeViewModel
import com.jesse.c25nys.presentation.uistate.UIState
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
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(modifier)
        }
        composable("details") {
            DetailsScreen(modifier)
        }
    }
}

@Composable
fun DetailsScreen(modifier: Modifier) {

}

@Composable
fun HomeScreen(modifier: Modifier, viewModel: HomeViewModel = hiltViewModel()) {

    val state by viewModel.uiState.collectAsState(UIState.Loading)

    when (state) {
        is UIState.Error -> Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) { Text(text = (state as UIState.Error).error) }

        UIState.Loading -> Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) { CircularProgressIndicator(modifier = modifier.size(48.dp)) }

        is UIState.Success -> {
            LazyColumn(modifier = modifier.background(Color.Cyan).fillMaxSize()) {
                items((state as UIState.Success).mySuccessList.size) {
                    ListItem(
                        modifier = modifier.padding(horizontal = 4.dp).fillMaxWidth().background(Color.White),
                        headlineContent = { Text(text = (state as UIState.Success).mySuccessList[it].name) },
                        supportingContent =
                        { val seats = (state as UIState.Success).mySuccessList[it].numOfSatTestTakers ?: "No Data"
                            val reading = (state as UIState.Success).mySuccessList[it].satCriticalReadingAvgScore ?: "No Data"
                            val math = (state as UIState.Success).mySuccessList[it].satMathAvgScore ?: "No Data"
                            val writing = (state as UIState.Success).mySuccessList[it].satWritingAvgScore ?: "No Data"
                            Text(
                                text = "Seats: $seats \n SAT Reading Score: $reading \n SAT Math Score: $math \n SAT Writing Score: $writing"
                                    ,modifier.fillMaxWidth() ,textAlign = TextAlign.End
                            )
                        },
                        leadingContent = {Icon(painterResource (R.drawable.baseline_school_24), contentDescription = null)})
                }
            }
        }
    }
}

