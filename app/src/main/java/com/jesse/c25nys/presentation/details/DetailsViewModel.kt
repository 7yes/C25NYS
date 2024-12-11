package com.jesse.c25nys.presentation.details

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jesse.c25nys.domain.GetByDbnUC
import com.jesse.c25nys.presentation.details.uiState.DetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val getByDbnUC: GetByDbnUC):ViewModel() {

    private val _state = MutableStateFlow<DetailsState>(DetailsState.Loading)
    val state: StateFlow<DetailsState> = _state

    fun getSchoolDetails(dbn:String) {
        Log.d("TAj", "getSchoolDetails: $dbn ")
       _state.value = DetailsState.Loading
       viewModelScope.launch {
           val data = getByDbnUC(dbn)
           if (data != null) {
               _state.value = DetailsState.Success(data)

               Log.d("TAj", "getSchoolDetails: ${data.name} ")
           } else {
               _state.value = DetailsState.Error("Something went wrong")
           }
       }
    }
}