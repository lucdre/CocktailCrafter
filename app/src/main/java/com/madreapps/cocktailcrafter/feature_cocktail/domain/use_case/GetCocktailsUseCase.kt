package com.madreapps.cocktailcrafter.feature_cocktail.domain.use_case

import com.madreapps.cocktailcrafter.feature_cocktail.domain.model.Cocktail
import com.madreapps.cocktailcrafter.feature_cocktail.domain.repository.CocktailRepository
import com.madreapps.cocktailcrafter.feature_cocktail.domain.util.CocktailOrder
import com.madreapps.cocktailcrafter.feature_cocktail.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCocktailsUseCase(
    private val repository: CocktailRepository
) {

    operator fun invoke(
        cocktailOrder: CocktailOrder = CocktailOrder.BaseSpirit(OrderType.Descending)
    ): Flow<List<Cocktail>> {
        return repository.getCocktails().map { cocktails ->
            when(cocktailOrder.orderType) {
                is OrderType.Ascending -> {
                    when(cocktailOrder) {
                        is CocktailOrder.Title -> cocktails.sortedBy { it.title.lowercase() }
                        is CocktailOrder.Date -> cocktails.sortedBy { it.timestamp }
                        is CocktailOrder.BaseSpirit -> cocktails.sortedBy { it.baseSpirit }
                    }
                }
                is OrderType.Descending -> {
                    when(cocktailOrder) {
                        is CocktailOrder.Title -> cocktails.sortedByDescending { it.title.lowercase() }
                        is CocktailOrder.Date -> cocktails.sortedByDescending { it.timestamp }
                        is CocktailOrder.BaseSpirit -> cocktails.sortedByDescending { it.baseSpirit }
                    }
                }
            }
        }
    }
}