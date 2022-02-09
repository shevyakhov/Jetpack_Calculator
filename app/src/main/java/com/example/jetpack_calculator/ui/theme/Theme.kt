package com.example.jetpack_calculator.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color.Companion.White

private val LightColorPalette = lightColors(
    surface = Blue,
    onSurface = White,
    primary = LightBlue,
    onPrimary = Navy
)
private val appPalette = lightColors(
    surface = background,
    onSurface = mainWhite,
    primary = mainBlue,
    secondary = mainGrey,
    )

@Composable
fun Jetpack_CalculatorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        appPalette
    } else {
        appPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}