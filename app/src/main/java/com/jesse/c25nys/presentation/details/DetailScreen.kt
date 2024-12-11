package com.jesse.c25nys.presentation.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jesse.c25nys.presentation.details.uiState.DetailsState

@Composable
fun DetailsScreen(modifier: Modifier, dbn: String, viewmodel: DetailsViewModel = hiltViewModel()) {
  LaunchedEffect(Unit) {
      viewmodel.getSchoolDetails(dbn)
  }
  val state by viewmodel.state.collectAsState()
    when(state){
        is DetailsState.Error -> Box (modifier=modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Text(text = (state as DetailsState.Error).error)
        }
        DetailsState.Loading ->  Box (modifier=modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            CircularProgressIndicator(modifier.size(64.dp))
        }
        is DetailsState.Success -> {
            val school = (state as DetailsState.Success).mySuccessSchool
            Column(modifier=Modifier.fillMaxSize().background(Color.Cyan).padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

                Text(text = "School Name: ${school.name}")
                Text(text = "Email: ${school.email}")
                Text(text = "Phone Number: ${school.phone_number}")
                Text(text = "Website: ${school.website}")
                Text(text = "Location: ${school.location}")
                Text(text = "school_sports: ${school.school_sports}")
                Text(text = "city: ${school.city}")
                Text(text = "zip: ${school.zip}")
                Text(text = "total_students: ${school.total_students}")
            }
        }
    }
}