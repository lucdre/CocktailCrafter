package com.madreapps.cocktailcrafter.feature_cocktail.presentation.util

sealed class Screen(val route: String) {
    object CocktailsScreen: Screen("cocktails_screen")
    object AddEditCocktailScreen: Screen("add_edit_cocktail_screen")
}