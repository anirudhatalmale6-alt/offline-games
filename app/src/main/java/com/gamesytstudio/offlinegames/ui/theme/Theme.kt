package com.gamesytstudio.offlinegames.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Dark theme colors
val BackgroundDark = Color(0xFF0D1117)
val SurfaceDark = Color(0xFF161B22)
val SurfaceVariantDark = Color(0xFF21262D)
val BlueAccent = Color(0xFF58A6FF)
val BlueAccentDark = Color(0xFF388BFD)
val TextPrimary = Color(0xFFFFFFFF)
val TextSecondary = Color(0xFF8B949E)
val TextTertiary = Color(0xFF6E7681)
val BorderDark = Color(0xFF30363D)
val SuccessGreen = Color(0xFF3FB950)
val WarningYellow = Color(0xFFD29922)
val ErrorRed = Color(0xFFF85149)

private val DarkColorScheme = darkColorScheme(
    primary = BlueAccent,
    onPrimary = Color.White,
    primaryContainer = BlueAccentDark,
    onPrimaryContainer = Color.White,
    secondary = BlueAccent,
    onSecondary = Color.White,
    secondaryContainer = SurfaceVariantDark,
    onSecondaryContainer = TextPrimary,
    tertiary = SuccessGreen,
    onTertiary = Color.White,
    background = BackgroundDark,
    onBackground = TextPrimary,
    surface = SurfaceDark,
    onSurface = TextPrimary,
    surfaceVariant = SurfaceVariantDark,
    onSurfaceVariant = TextSecondary,
    outline = BorderDark,
    outlineVariant = BorderDark,
    error = ErrorRed,
    onError = Color.White,
)

@Composable
fun OfflineGamesTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            @Suppress("DEPRECATION")
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.VANILLA_ICE_CREAM) {
                window.statusBarColor = colorScheme.background.toArgb()
                window.navigationBarColor = colorScheme.background.toArgb()
            }
            WindowCompat.getInsetsController(window, view).apply {
                isAppearanceLightStatusBars = false
                isAppearanceLightNavigationBars = false
            }
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
