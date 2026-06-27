package com.safehelplineindia.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = SafetyTeal,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFE0F2EF),
    onPrimaryContainer = SafetyTealDark,
    secondary = CivicBlue,
    onSecondary = Color.White,
    tertiary = WomenPurple,
    error = EmergencyRed,
    background = SoftBackground,
    onBackground = Color(0xFF17202A),
    surface = SoftSurface,
    onSurface = Color(0xFF17202A),
    surfaceVariant = Color(0xFFEFF4F1),
    outline = BorderGray
)

@Composable
fun SafeHelplineIndiaTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = AppTypography,
        content = content
    )
}
