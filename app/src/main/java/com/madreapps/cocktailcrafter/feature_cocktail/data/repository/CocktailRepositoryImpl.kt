package com.madreapps.cocktailcrafter.feature_cocktail.data.repository

import com.madreapps.cocktailcrafter.feature_cocktail.data.data_source.CocktailDao
import com.madreapps.cocktailcrafter.feature_cocktail.domain.model.Cocktail
import com.madreapps.cocktailcrafter.feature_cocktail.domain.repository.CocktailRepository
import kotlinx.coroutines.flow.Flow

class CocktailRepositoryImpl(
    private val dao: CocktailDao
) : CocktailRepository {

    override fun getCocktails(): Flow<List<Cocktail>> {
        return dao.getCocktails()
    }

    override suspend fun getCocktailById(id: Int): Cocktail? {
        return dao.getCocktailById(id)
    }

    override suspend fun insertCocktail(cocktail: Cocktail) {
        dao.insertCocktail(cocktail)
    }

    override suspend fun deleteCocktail(cocktail: Cocktail) {
        dao.deleteCocktail(cocktail)
    }
}