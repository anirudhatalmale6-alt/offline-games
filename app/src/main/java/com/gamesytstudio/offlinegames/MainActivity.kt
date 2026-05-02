package com.gamesytstudio.offlinegames

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.gamesytstudio.offlinegames.ui.navigation.AppNavigation
import com.gamesytstudio.offlinegames.ui.theme.OfflineGamesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OfflineGamesTheme {
                AppNavigation()
            }
        }
    }
}
