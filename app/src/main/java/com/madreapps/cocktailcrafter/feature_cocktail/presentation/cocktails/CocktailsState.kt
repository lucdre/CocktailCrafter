package com.madreapps.cocktailcrafter.feature_cocktail.presentation.cocktails

import com.madreapps.cocktailcrafter.feature_cocktail.domain.model.Cocktail
import com.madreapps.cocktailcrafter.feature_cocktail.domain.util.CocktailOrder
import com.madreapps.cocktailcrafter.feature_cocktail.domain.util.OrderType

data class CocktailsState(
    val cocktails: List<Cocktail> = emptyList(),
    val cocktailOrder: CocktailOrder = CocktailOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
