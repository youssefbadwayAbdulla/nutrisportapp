package com.compose.nutrisportapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.mmk.kmpauth.google.GoogleAuthCredentials
import com.mmk.kmpauth.google.GoogleAuthProvider
import com.nutrisport.navigation.SetupNavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun App() {
    var appReady by remember { mutableStateOf(false) }

    NutriSportTheme {
        LaunchedEffect(Unit) {
            GoogleAuthProvider.create(
                credentials = GoogleAuthCredentials(serverId = Constants.WEB_CLIENT_ID)
            )
            appReady = true
        }

        AnimatedVisibility(
            modifier = Modifier.fillMaxSize(),
            visible = appReady
        ) {
            SetupNavGraph()
        }
    }
}

@Preview
@Composable
private fun AppPreview() {
    NutriSportPreview(layout = PreviewLayout.Screen) {
        App()
    }
}
