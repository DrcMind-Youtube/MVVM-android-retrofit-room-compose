package com.drcmind.androidretrofitroomjetpackcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.drcmind.androidretrofitroomjetpackcompose.ui.theme.AndroidRetrofitRoomJetpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidRetrofitRoomJetpackComposeTheme {
                val viewModel : MainViewModel = hiltViewModel()

                MyScreen(
                    onGenerate = { viewModel.getRandomJoke() },
                    uiState = viewModel.uiState.value
                )

            }
        }
    }
}

