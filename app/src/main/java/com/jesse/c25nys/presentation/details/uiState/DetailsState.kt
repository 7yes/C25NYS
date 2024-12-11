package com.jesse.c25nys.presentation.details.uiState

import com.jesse.c25nys.domain.model.DbnItem

sealed class DetailsState {
        data object Loading: DetailsState()
        data class Error(val error:String): DetailsState()
        data class Success(val mySuccessSchool:DbnItem): DetailsState()
}