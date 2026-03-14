package com.example.myfirstkmpapp

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myfirstkmpapp.ui.ProfileScreen
import com.example.myfirstkmpapp.viewmodel.ProfileViewModel
import androidx.compose.ui.tooling.preview.Preview

val PinkPrimary = Color(0xFFD81B60)
val PinkSecondary = Color(0xFFF06292)

val LightColorScheme = lightColorScheme(
    primary = PinkPrimary,
    onPrimary = Color.White,
    background = Color(0xFFF3F2EF),
    surface = Color.White,
    onSurface = Color(0xFF191919)
)

val DarkColorScheme = darkColorScheme(
    primary = PinkSecondary,
    onPrimary = Color.Black,
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    onSurface = Color(0xFFE0E0E0)
)

@Composable
@Preview
fun App(viewModel: ProfileViewModel = viewModel { ProfileViewModel() }) {
    val uiState by viewModel.uiState.collectAsState()

    val colorScheme = if (uiState.isDarkMode) DarkColorScheme else LightColorScheme
    val animatedBackground by animateColorAsState(targetValue = colorScheme.background, tween(500))

    MaterialTheme(colorScheme = colorScheme) {
        Box(modifier = Modifier.fillMaxSize().background(animatedBackground)) {
             ProfileScreen(
                uiState = uiState,
                onNameChange = { viewModel.updateName(it) },
                onBioChange = { viewModel.updateBio(it) },
                onToggleBio = { viewModel.toggleBioVisibility() },
                onToggleEdit = { viewModel.toggleEditMode() },
                onToggleDarkMode = { viewModel.toggleDarkMode() }
            )
        }
    }
}