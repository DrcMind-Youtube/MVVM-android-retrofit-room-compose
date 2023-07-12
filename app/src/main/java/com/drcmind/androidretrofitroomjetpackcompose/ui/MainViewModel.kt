package com.drcmind.androidretrofitroomjetpackcompose.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drcmind.androidretrofitroomjetpackcompose.data.repository.JokeRepository
import com.drcmind.androidretrofitroomjetpackcompose.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: JokeRepository
) : ViewModel() {

    val uiState = mutableStateOf(UiState())

    init {
        getRandomJoke()
    }

    fun getRandomJoke(){
        viewModelScope.launch {
            repository.getRandomJoke().collect{result->
                when (result){
                    is Result.Loading->{
                        uiState.value = UiState(isLoading = true)
                    }
                    is Result.Success->{
                        uiState.value = UiState(currentQuote = result.data)
                    }
                    is Result.Error->{
                        uiState.value = UiState(
                            error = result.message,
                            currentQuote = result.data
                        )
                    }
                }
            }
        }
    }
}