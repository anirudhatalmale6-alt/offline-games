package com.gamesytstudio.offlinegames.model

data class Game(
    val id: String,
    val name: String,
    val category: String,
    val assetPath: String,
    val icon: String = ""
)
