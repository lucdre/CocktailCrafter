package com.madreapps.cocktailcrafter.feature_cocktail.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.madreapps.cocktailcrafter.feature_cocktail.presentation.add_edit_cocktail.AddEditCocktailScreen
import com.madreapps.cocktailcrafter.feature_cocktail.presentation.cocktails.CocktailsScreen
import com.madreapps.cocktailcrafter.feature_cocktail.presentation.util.Screen
import com.madreapps.cocktailcrafter.ui.theme.CocktailAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CocktailAppTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CocktailsScreen.route
                    ) {
                        composable(route = Screen.CocktailsScreen.route) {
                            CocktailsScreen(navController = navController)
                        }
                        composable(
                            route = Screen.AddEditCocktailScreen.route +
                                    "?cocktailId={cocktailId}&cocktailColor={cocktailColor}",
                            arguments = listOf(
                                navArgument(
                                    name = "cocktailId"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(
                                    name = "cocktailColor"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                            )
                        ) {
                            val color = it.arguments?.getInt("cocktailColor") ?: -1
                            AddEditCocktailScreen(
                                navController = navController,
                                cocktailColor = color
                            )
                        }
                    }
                }
            }
        }
    }
}