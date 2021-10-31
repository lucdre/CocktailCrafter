package com.madreapps.cocktailcrafter.feature_cocktail.presentation.cocktails

import com.madreapps.cocktailcrafter.feature_cocktail.domain.model.Cocktail
import com.madreapps.cocktailcrafter.feature_cocktail.domain.util.CocktailOrder

sealed class CocktailsEvent {
    data class Order(val cocktailOrder: CocktailOrder): CocktailsEvent()
    data class DeleteCocktail(val cocktail: Cocktail): CocktailsEvent()
    object RestoreCocktail: CocktailsEvent()
    object ToggleOrderSection: CocktailsEvent()
}