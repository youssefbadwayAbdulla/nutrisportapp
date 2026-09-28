package com.nutrisport.navigation

import androidx.compose.runtime.Composable
import com.compose.nutrisportapp.NutriSportPreview
import com.compose.nutrisportapp.PreviewLayout
import com.nutrisport.auth.AuthScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SetupNavGraph() {
    AuthScreen()
}

@Preview
@Composable
private fun SetupNavGraphPreview() {
    NutriSportPreview(layout = PreviewLayout.Screen) {
        SetupNavGraph()
    }
}
