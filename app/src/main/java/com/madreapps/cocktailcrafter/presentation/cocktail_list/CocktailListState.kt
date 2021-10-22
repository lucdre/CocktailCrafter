package com.madreapps.cocktailcrafter.presentation.cocktail_list

import com.madreapps.cocktailcrafter.domain.model.Cocktail

data class CocktailListState(
    val isLoading: Boolean = false,
    val cocktails: List<Cocktail> = emptyList(),
    val error: String = ""
)