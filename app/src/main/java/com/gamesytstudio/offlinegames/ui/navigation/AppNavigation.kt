package com.gamesytstudio.offlinegames.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gamesytstudio.offlinegames.ui.screens.CategoryScreen
import com.gamesytstudio.offlinegames.ui.screens.GameScreen
import com.gamesytstudio.offlinegames.ui.screens.HomeScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                onGameClick = { gameId ->
                    navController.navigate("game/$gameId")
                },
                onCategoryClick = { categoryName ->
                    navController.navigate("category/$categoryName")
                }
            )
        }

        composable(
            route = "category/{categoryName}",
            arguments = listOf(
                navArgument("categoryName") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val categoryName = backStackEntry.arguments?.getString("categoryName") ?: ""
            CategoryScreen(
                categoryName = categoryName,
                onGameClick = { gameId ->
                    navController.navigate("game/$gameId")
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = "game/{gameId}",
            arguments = listOf(
                navArgument("gameId") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val gameId = backStackEntry.arguments?.getString("gameId") ?: ""
            GameScreen(
                gameId = gameId,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
