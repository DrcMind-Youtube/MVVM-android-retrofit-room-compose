package com.drcmind.androidretrofitroomjetpackcompose.ui

data class UiState(
    val isLoading: Boolean = false,
    val currentQuote : String? = null,
    val error : String? = null
)
