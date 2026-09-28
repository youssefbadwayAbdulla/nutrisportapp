package com.nutrisport.auth

import ContentWithMessageBar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.compose.nutrisportapp.Alpha
import com.compose.nutrisportapp.BebasNeueFont
import com.compose.nutrisportapp.FontSize
import com.compose.nutrisportapp.NutriSportPreview
import com.compose.nutrisportapp.PreviewLayout
import com.compose.nutrisportapp.TextPrimary
import com.compose.nutrisportapp.TextSecondary
import com.nutrisport.auth.component.GoogleButton
import rememberMessageBarState
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun AuthScreen() {
    val messageBarState = rememberMessageBarState()
    Scaffold { paddingValues ->
        ContentWithMessageBar(
            modifier = Modifier.padding(
                top = paddingValues.calculateTopPadding(),
                bottom = paddingValues.calculateBottomPadding(),
            ),
            messageBarState = messageBarState,
            errorMaxLines = 2,
        ) {
            Column(modifier = Modifier.fillMaxSize().padding(all = 16.dp)) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "NUTRISPORT",
                        textAlign = TextAlign.Center,
                        fontFamily = BebasNeueFont(),
                        fontSize = FontSize.EXTRA_LARGE,
                        color = TextSecondary
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .alpha(Alpha.HALF),
                        text = "Sign in to continue",
                        textAlign = TextAlign.Center,
                        fontSize = FontSize.EXTRA_REGULAR,
                        color = TextPrimary
                    )
                }
                GoogleButton(
                    loading = false,
                    onClick = {
                        messageBarState.addError("Not implemented yet")
                    },
                )
            }
        }
    }
}

@Preview
@Composable
private fun AuthScreenPreview() {
    NutriSportPreview(layout = PreviewLayout.Screen) {
        AuthScreen()
    }
}
