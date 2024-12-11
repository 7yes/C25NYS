package com.jesse.c25nys.presentation.home.uistate

import com.jesse.c25nys.domain.model.SchoolsItem

sealed class UIState {
        data object Loading: UIState()
        data class Error(val error:String): UIState()
        data class Success(val mySuccessList:List<SchoolsItem>): UIState()
    }