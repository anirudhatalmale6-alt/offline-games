package com.gamesytstudio.offlinegames.data

import com.gamesytstudio.offlinegames.model.Game

object GameRepository {

    // Display name mapping for all game folders
    private val displayNames = mapOf(
        "among_us" to "Among Us",
        "balloons_creator" to "Balloons Creator",
        "block_blast" to "Block Blast",
        "block_merge" to "Block Merge",
        "block_tetris" to "Block Tetris",
        "brainrot_merge" to "Brainrot Merge",
        "brick_breaker_retro" to "Brick Breaker Retro",
        "bubble_shooter" to "Bubble Shooter",
        "cap_sort" to "Cap Sort",
        "checkers" to "Checkers",
        "chess" to "Chess",
        "city_builder" to "City Builder",
        "coin_sort" to "Coin Sort",
        "collect_em_all" to "Collect Em All",
        "color_by_number" to "Color by Number",
        "color_cannon" to "Color Cannon",
        "coloring_book" to "Coloring Book",
        "color_maze" to "Color Maze",
        "crazy_fishing" to "Crazy Fishing",
        "cryptogram" to "Cryptogram",
        "dice_merge" to "Dice Merge",
        "dominoes" to "Dominoes",
        "draw_parking" to "Draw Parking",
        "drop_it" to "Drop It",
        "drop_n_merge" to "Drop N Merge",
        "find_number" to "Find Number",
        "find_pair" to "Find Pair",
        "fruit_king" to "Fruit King",
        "geometry_rash" to "Geometry Rash",
        "golf_day" to "Golf Day",
        "happy_filled_glass" to "Happy Filled Glass",
        "happy_filled_glass_2" to "Happy Filled Glass 2",
        "happy_filled_glass_4" to "Happy Filled Glass 4",
        "head_soccer" to "Head Soccer",
        "hexadice" to "Hexadice",
        "house_painter" to "House Painter",
        "how_to_loot" to "How to Loot",
        "indiara" to "Indiara",
        "jigsaw_puzzle" to "Jigsaw Puzzle",
        "knife_hit" to "Knife Hit",
        "link_2248" to "Link 2248",
        "ludo" to "Ludo",
        "mahjong_classic" to "Mahjong Classic",
        "mahjong_deluxe" to "Mahjong Deluxe",
        "master_fall_down" to "Master Fall Down",
        "math" to "Math",
        "merge_bubble" to "Merge Bubble",
        "merge_cards" to "Merge Cards",
        "merge_dice" to "Merge Dice",
        "merge_fruits" to "Merge Fruits",
        "merge_numbers" to "Merge Numbers",
        "merge_shooter" to "Merge Shooter",
        "move_the_pin_2" to "Move the Pin 2",
        "mr_bullet" to "Mr Bullet",
        "nonogram" to "Nonogram",
        "number_tiles" to "Number Tiles",
        "nuts_and_bolts" to "Nuts and Bolts",
        "nuts_and_bolts_sort" to "Nuts and Bolts Sort",
        "onet_fish" to "Onet Fish",
        "pao_pao" to "Pao Pao",
        "pinball_rush" to "Pinball Rush",
        "pipe_way" to "Pipe Way",
        "pool_8_pro" to "Pool 8 Pro",
        "pool_shoot" to "Pool Shoot",
        "rope_bowling" to "Rope Bowling",
        "route_digger" to "Route Digger",
        "royal_blast" to "Royal Blast",
        "screw_pin" to "Screw Pin",
        "sheep_and_sheep" to "Sheep and Sheep",
        "shooting_balls" to "Shooting Balls",
        "slider_puzzle" to "Slider Puzzle",
        "solitaire" to "Solitaire",
        "solitaire_associations" to "Solitaire Associations",
        "solitaire_classic" to "Solitaire Classic",
        "solitaire_spider" to "Solitaire Spider",
        "spades" to "Spades",
        "spill_wine" to "Spill Wine",
        "sudoku" to "Sudoku",
        "tanks_battle" to "Tanks Battle",
        "thread_match" to "Thread Match",
        "tic_tac_toe" to "Tic Tac Toe",
        "tile_master_match" to "Tile Master Match",
        "tiny_crash_fighters" to "Tiny Crash Fighters",
        "tower_boom" to "Tower Boom",
        "turn_light" to "Turn Light",
        "twenty48" to "2048",
        "uno" to "UNO",
        "uno_vertical" to "UNO Vertical",
        "water_sort" to "Water Sort",
        "word_connect" to "Word Connect",
        "wordly" to "Wordly",
        "word_search_hidden_2" to "Word Search Hidden 2",
        "zombie_tower_defence" to "Zombie Tower Defence",
        "zumba" to "Zumba"
    )

    // Category assignments
    private val categoryMap = mapOf(
        // Puzzle
        "block_blast" to "Puzzle",
        "block_tetris" to "Puzzle",
        "cap_sort" to "Puzzle",
        "coin_sort" to "Puzzle",
        "color_maze" to "Puzzle",
        "cryptogram" to "Puzzle",
        "find_number" to "Puzzle",
        "find_pair" to "Puzzle",
        "jigsaw_puzzle" to "Puzzle",
        "link_2248" to "Puzzle",
        "mahjong_classic" to "Puzzle",
        "mahjong_deluxe" to "Puzzle",
        "nonogram" to "Puzzle",
        "number_tiles" to "Puzzle",
        "nuts_and_bolts" to "Puzzle",
        "nuts_and_bolts_sort" to "Puzzle",
        "onet_fish" to "Puzzle",
        "pipe_way" to "Puzzle",
        "screw_pin" to "Puzzle",
        "slider_puzzle" to "Puzzle",
        "tile_master_match" to "Puzzle",
        "water_sort" to "Puzzle",
        "word_connect" to "Puzzle",
        "wordly" to "Puzzle",
        "word_search_hidden_2" to "Puzzle",
        "sudoku" to "Puzzle",
        "sheep_and_sheep" to "Puzzle",
        "pao_pao" to "Puzzle",
        "hexadice" to "Puzzle",
        "thread_match" to "Puzzle",
        "turn_light" to "Puzzle",

        // Arcade
        "among_us" to "Arcade",
        "brick_breaker_retro" to "Arcade",
        "geometry_rash" to "Arcade",
        "head_soccer" to "Arcade",
        "knife_hit" to "Arcade",
        "mr_bullet" to "Arcade",
        "pinball_rush" to "Arcade",
        "pool_8_pro" to "Arcade",
        "pool_shoot" to "Arcade",
        "shooting_balls" to "Arcade",
        "tanks_battle" to "Arcade",
        "tiny_crash_fighters" to "Arcade",
        "zombie_tower_defence" to "Arcade",
        "zumba" to "Arcade",
        "rope_bowling" to "Arcade",
        "tower_boom" to "Arcade",

        // Casual
        "bubble_shooter" to "Casual",
        "crazy_fishing" to "Casual",
        "draw_parking" to "Casual",
        "drop_it" to "Casual",
        "fruit_king" to "Casual",
        "golf_day" to "Casual",
        "house_painter" to "Casual",
        "indiara" to "Casual",
        "ludo" to "Casual",
        "master_fall_down" to "Casual",
        "move_the_pin_2" to "Casual",
        "route_digger" to "Casual",
        "royal_blast" to "Casual",
        "spill_wine" to "Casual",

        // Merge
        "block_merge" to "Merge",
        "brainrot_merge" to "Merge",
        "dice_merge" to "Merge",
        "drop_n_merge" to "Merge",
        "merge_bubble" to "Merge",
        "merge_cards" to "Merge",
        "merge_dice" to "Merge",
        "merge_fruits" to "Merge",
        "merge_numbers" to "Merge",
        "merge_shooter" to "Merge",
        "twenty48" to "Merge",

        // Card
        "checkers" to "Card",
        "chess" to "Card",
        "dominoes" to "Card",
        "solitaire" to "Card",
        "solitaire_associations" to "Card",
        "solitaire_classic" to "Card",
        "solitaire_spider" to "Card",
        "spades" to "Card",
        "uno" to "Card",
        "uno_vertical" to "Card",

        // Creative
        "balloons_creator" to "Creative",
        "city_builder" to "Creative",
        "color_by_number" to "Creative",
        "color_cannon" to "Creative",
        "coloring_book" to "Creative",

        // Strategy
        "how_to_loot" to "Strategy",
        "happy_filled_glass" to "Strategy",
        "happy_filled_glass_2" to "Strategy",
        "happy_filled_glass_4" to "Strategy",
        "math" to "Strategy",
        "collect_em_all" to "Strategy",
        "tic_tac_toe" to "Strategy"
    )

    // All game folder names
    private val allGameFolders = listOf(
        "among_us", "balloons_creator", "block_blast", "block_merge", "block_tetris",
        "brainrot_merge", "brick_breaker_retro", "bubble_shooter", "cap_sort", "checkers",
        "chess", "city_builder", "coin_sort", "collect_em_all", "color_by_number",
        "color_cannon", "coloring_book", "color_maze", "crazy_fishing", "cryptogram",
        "dice_merge", "dominoes", "draw_parking", "drop_it", "drop_n_merge",
        "find_number", "find_pair", "fruit_king", "geometry_rash", "golf_day",
        "happy_filled_glass", "happy_filled_glass_2", "happy_filled_glass_4", "head_soccer", "hexadice",
        "house_painter", "how_to_loot", "indiara", "jigsaw_puzzle", "knife_hit",
        "link_2248", "ludo", "mahjong_classic", "mahjong_deluxe", "master_fall_down",
        "math", "merge_bubble", "merge_cards", "merge_dice", "merge_fruits",
        "merge_numbers", "merge_shooter", "move_the_pin_2", "mr_bullet", "nonogram",
        "number_tiles", "nuts_and_bolts", "nuts_and_bolts_sort", "onet_fish", "pao_pao",
        "pinball_rush", "pipe_way", "pool_8_pro", "pool_shoot", "rope_bowling",
        "route_digger", "royal_blast", "screw_pin", "sheep_and_sheep", "shooting_balls",
        "slider_puzzle", "solitaire", "solitaire_associations", "solitaire_classic", "solitaire_spider",
        "spades", "spill_wine", "sudoku", "tanks_battle", "thread_match",
        "tic_tac_toe", "tile_master_match", "tiny_crash_fighters", "tower_boom", "turn_light",
        "twenty48", "uno", "uno_vertical", "water_sort", "word_connect",
        "wordly", "word_search_hidden_2", "zombie_tower_defence", "zumba"
    )

    val categories = listOf("All", "Puzzle", "Arcade", "Casual", "Merge", "Card", "Creative", "Strategy")

    fun getAllGames(): List<Game> {
        return allGameFolders.map { folder ->
            Game(
                id = folder,
                name = displayNames[folder] ?: folder.replace("_", " ")
                    .split(" ")
                    .joinToString(" ") { it.replaceFirstChar { c -> c.uppercase() } },
                category = categoryMap[folder] ?: "Casual",
                assetPath = "file:///android_asset/games/$folder/index.html",
                icon = "file:///android_asset/games/$folder/icon.png",
                engine = "html5"
            )
        }.sortedBy { it.name }
    }

    fun getGamesByCategory(category: String): List<Game> {
        if (category == "All") return getAllGames()
        return getAllGames().filter { it.category == category }
    }

    fun getGameById(id: String): Game? {
        return getAllGames().find { it.id == id }
    }

    fun searchGames(query: String): List<Game> {
        val lowerQuery = query.lowercase()
        return getAllGames().filter {
            it.name.lowercase().contains(lowerQuery) ||
            it.category.lowercase().contains(lowerQuery)
        }
    }

    fun getGameCount(): Int = allGameFolders.size

    fun getCategoryCount(category: String): Int {
        if (category == "All") return allGameFolders.size
        return allGameFolders.count { categoryMap[it] == category }
    }
}
