package com.gamesytstudio.offlinegames.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gamesytstudio.offlinegames.data.GameRepository
import com.gamesytstudio.offlinegames.ui.components.CategoryColors
import com.gamesytstudio.offlinegames.ui.components.GameCard
import com.gamesytstudio.offlinegames.ui.components.GameCardGrid
import com.gamesytstudio.offlinegames.ui.theme.*

@Composable
fun HomeScreen(
    onGameClick: (String) -> Unit,
    onCategoryClick: (String) -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    val allGames = remember { GameRepository.getAllGames() }
    val categories = remember { GameRepository.categories.filter { it != "All" } }
    val searchResults = remember(searchQuery) {
        if (searchQuery.isNotBlank()) GameRepository.searchGames(searchQuery) else emptyList()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundDark)
            .statusBarsPadding()
    ) {
        // Header
        Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp)) {
            Text(
                text = "Offline Games",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )
            Text(
                text = "${GameRepository.getGameCount()} games available",
                fontSize = 14.sp,
                color = TextSecondary
            )
        }

        // Search bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(bottom = 16.dp)
                .height(48.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(SurfaceDark)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Default.Search,
                    contentDescription = null,
                    tint = TextTertiary,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(Modifier.width(12.dp))
                Box(modifier = Modifier.weight(1f)) {
                    if (searchQuery.isEmpty()) {
                        Text("Search games...", color = TextTertiary, fontSize = 15.sp)
                    }
                    BasicTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        textStyle = TextStyle(color = TextPrimary, fontSize = 15.sp),
                        cursorBrush = SolidColor(BlueAccent),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                if (searchQuery.isNotEmpty()) {
                    IconButton(
                        onClick = { searchQuery = "" },
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(Icons.Default.Clear, contentDescription = null, tint = TextSecondary, modifier = Modifier.size(18.dp))
                    }
                }
            }
        }

        if (searchQuery.isNotBlank()) {
            // Search results grid
            if (searchResults.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No games found", color = TextSecondary, fontSize = 16.sp)
                }
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(searchResults) { game ->
                        GameCardGrid(game = game, onClick = { onGameClick(game.id) })
                    }
                }
            }
        } else {
            // Categories with horizontal game rows
            LazyColumn(
                contentPadding = PaddingValues(bottom = 32.dp)
            ) {
                items(categories) { category ->
                    val categoryGames = remember(category) {
                        GameRepository.getGamesByCategory(category)
                    }
                    val categoryColor = CategoryColors.getColor(category)

                    // Category header
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 8.dp, bottom = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(4.dp, 18.dp)
                                    .clip(RoundedCornerShape(2.dp))
                                    .background(categoryColor)
                            )
                            Spacer(Modifier.width(10.dp))
                            Text(
                                text = category,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = TextPrimary
                            )
                            Spacer(Modifier.width(8.dp))
                            Text(
                                text = "${categoryGames.size}",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Normal,
                                color = TextSecondary
                            )
                        }
                        Text(
                            text = "See All",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium,
                            color = BlueAccent,
                            modifier = Modifier.clickable { onCategoryClick(category) }
                        )
                    }

                    // Horizontal game row
                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.padding(bottom = 12.dp)
                    ) {
                        items(categoryGames) { game ->
                            GameCard(game = game, onClick = { onGameClick(game.id) })
                        }
                    }
                }
            }
        }
    }
}
