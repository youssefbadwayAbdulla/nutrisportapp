package com.nutrisport.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.nutrisportapp.NutriSportPreview
import com.compose.nutrisportapp.PreviewLayout
import com.nutrisport.auth.AuthScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SetupNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Auth
    ) {
        composable<Screen.Auth> {
            AuthScreen()
        }
    }
}

@Preview
@Composable
private fun SetupNavGraphPreview() {
    NutriSportPreview(layout = PreviewLayout.Screen) {
        SetupNavGraph()
    }
}
