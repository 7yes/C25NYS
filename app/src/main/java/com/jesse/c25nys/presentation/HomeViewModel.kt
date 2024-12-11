package com.jesse.c25nys.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jesse.c25nys.data.SchoolsRepo
import com.jesse.c25nys.presentation.uistate.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo: SchoolsRepo) :ViewModel() {


    private val _uiState = MutableStateFlow<UIState>(UIState.Loading)
    val uiState: StateFlow<UIState> = _uiState

    init {
        getSchools()
    }

    private fun getSchools(){
        _uiState.value = UIState.Loading
        viewModelScope.launch {
            val data = repo.getAllSchools()
           if (data.isNotEmpty()){
               _uiState.value = UIState.Success(data)
           }else{
               _uiState.value = UIState.Error("No data found")
           }
        }
    }
}