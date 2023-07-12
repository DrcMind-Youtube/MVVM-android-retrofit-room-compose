package com.drcmind.androidretrofitroomjetpackcompose.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScreen(
    onGenerate : ()->Unit,
    uiState: UiState
){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "GeekJokesApp",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            )
        }
    ) {paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ){
            if(uiState.isLoading){
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }else{
                if (uiState.currentQuote!=null){
                    Text(text = uiState.currentQuote, fontSize = 20.sp, modifier = Modifier.align(Alignment.Center))
                }else{
                    Text(text = uiState.error!!, modifier = Modifier.align(Alignment.Center))
                }
            }

            Button(
                onClick = onGenerate,
                enabled = !uiState.isLoading,
                modifier = Modifier.align(Alignment.BottomCenter).padding(16.dp)
            ) {
                Text(text = "Nouveau Joke")
            }

        }
    }
}