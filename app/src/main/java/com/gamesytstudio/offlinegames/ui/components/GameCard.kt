package com.gamesytstudio.offlinegames.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gamesytstudio.offlinegames.model.Game
import com.gamesytstudio.offlinegames.ui.theme.BorderDark
import com.gamesytstudio.offlinegames.ui.theme.SurfaceDark
import com.gamesytstudio.offlinegames.ui.theme.TextPrimary
import com.gamesytstudio.offlinegames.ui.theme.TextSecondary

// Category color mapping
object CategoryColors {
    private val colors = mapOf(
        "Puzzle" to Color(0xFF4FC3F7),
        "Arcade" to Color(0xFFEF5350),
        "Casual" to Color(0xFF66BB6A),
        "Merge" to Color(0xFFAB47BC),
        "Card" to Color(0xFFFFB74D),
        "Strategy" to Color(0xFF26A69A),
        "Creative" to Color(0xFFF06292)
    )

    fun getColor(category: String): Color {
        return colors[category] ?: Color(0xFF58A6FF)
    }
}

@Composable
fun GameCard(
    game: Game,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val categoryColor = CategoryColors.getColor(game.category)
    val cardShape = RoundedCornerShape(16.dp)

    Column(
        modifier = modifier
            .width(120.dp)
            .height(140.dp)
            .clip(cardShape)
            .background(SurfaceDark)
            .border(
                width = 1.dp,
                color = BorderDark,
                shape = cardShape
            )
            .clickable(onClick = onClick)
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Icon circle with gradient
        Box(
            modifier = Modifier
                .size(52.dp)
                .clip(CircleShape)
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            categoryColor,
                            categoryColor.copy(alpha = 0.6f)
                        )
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = game.name.first().uppercase(),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Game name
        Text(
            text = game.name,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = TextPrimary,
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            lineHeight = 14.sp
        )
    }
}

@Composable
fun GameCardGrid(
    game: Game,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val categoryColor = CategoryColors.getColor(game.category)
    val cardShape = RoundedCornerShape(16.dp)

    Column(
        modifier = modifier
            .clip(cardShape)
            .background(SurfaceDark)
            .border(
                width = 1.dp,
                color = BorderDark,
                shape = cardShape
            )
            .clickable(onClick = onClick)
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Icon circle with gradient
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            categoryColor,
                            categoryColor.copy(alpha = 0.6f)
                        )
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = game.name.first().uppercase(),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Game name
        Text(
            text = game.name,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = TextPrimary,
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            lineHeight = 14.sp
        )

        // Category label
        Text(
            text = game.category,
            fontSize = 10.sp,
            fontWeight = FontWeight.Normal,
            color = TextSecondary,
            textAlign = TextAlign.Center,
            maxLines = 1
        )
    }
}
