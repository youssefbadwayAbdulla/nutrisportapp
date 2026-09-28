package com.compose.nutrisportapp

import androidx.compose.runtime.Composable
import com.nutrisport.navigation.SetupNavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun App() {
    NutriSportTheme {
        SetupNavGraph()
    }
}

@Preview
@Composable
private fun AppPreview() {
    NutriSportPreview(layout = PreviewLayout.Screen) {
        App()
    }
}
