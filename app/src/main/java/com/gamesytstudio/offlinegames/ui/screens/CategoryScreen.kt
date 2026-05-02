package com.gamesytstudio.offlinegames.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gamesytstudio.offlinegames.data.GameRepository
import com.gamesytstudio.offlinegames.ui.components.CategoryColors
import com.gamesytstudio.offlinegames.ui.components.GameCardGrid
import com.gamesytstudio.offlinegames.ui.theme.*

@Composable
fun CategoryScreen(
    categoryName: String,
    onGameClick: (String) -> Unit,
    onBackClick: () -> Unit
) {
    val games = remember(categoryName) { GameRepository.getGamesByCategory(categoryName) }
    val categoryColor = CategoryColors.getColor(categoryName)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundDark)
            .statusBarsPadding()
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBackClick) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = TextPrimary
                )
            }
            Spacer(Modifier.width(4.dp))
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .clip(CircleShape)
                    .background(categoryColor)
            )
            Spacer(Modifier.width(10.dp))
            Text(
                text = categoryName,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )
            Spacer(Modifier.width(10.dp))
            Text(
                text = "${games.size} games",
                fontSize = 14.sp,
                color = TextSecondary
            )
        }

        // Grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(games) { game ->
                GameCardGrid(game = game, onClick = { onGameClick(game.id) })
            }
        }
    }
}
