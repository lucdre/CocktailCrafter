package com.madreapps.cocktailcrafter.presentation.cocktail_detail

import com.madreapps.cocktailcrafter.domain.model.Cocktail
import com.madreapps.cocktailcrafter.domain.model.CocktailDetail

data class CocktailDetailState(
    val isLoading: Boolean = false,
    val cocktail: CocktailDetail? = null,
    val error: String = ""
)