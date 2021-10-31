package com.madreapps.cocktailcrafter.feature_cocktail.domain.repository

import com.madreapps.cocktailcrafter.feature_cocktail.domain.model.Cocktail
import kotlinx.coroutines.flow.Flow

interface CocktailRepository {

    fun getCocktails(): Flow<List<Cocktail>>

    suspend fun getCocktailById(id: Int): Cocktail?

    suspend fun insertCocktail(cocktail: Cocktail)

    suspend fun deleteCocktail(cocktail: Cocktail)
}