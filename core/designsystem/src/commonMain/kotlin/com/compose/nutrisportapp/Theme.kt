package com.compose.nutrisportapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private val NutriSportColorScheme = lightColorScheme(
    primary = ButtonPrimary,
    onPrimary = TextPrimary,
    secondary = SurfaceSecondary,
    onSecondary = TextWhite,
    background = Surface,
    onBackground = TextPrimary,
    surface = Surface,
    onSurface = TextPrimary,
    error = SurfaceError,
    onError = TextWhite,
)

@Composable
fun NutriSportTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = NutriSportColorScheme,
        content = content,
    )
}

enum class PreviewLayout {
    Item,
    Screen,
}

/** Provides the app theme and the appropriate bounds for item and screen previews. */
@Composable
fun NutriSportPreview(
    layout: PreviewLayout,
    content: @Composable () -> Unit,
) {
    NutriSportTheme {
        when (layout) {
            PreviewLayout.Item -> {
                Surface(
                    modifier = Modifier.wrapContentSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Box(modifier = Modifier.padding(16.dp)) {
                        content()
                    }
                }
            }

            PreviewLayout.Screen -> {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                    content = content,
                )
            }
        }
    }
}
