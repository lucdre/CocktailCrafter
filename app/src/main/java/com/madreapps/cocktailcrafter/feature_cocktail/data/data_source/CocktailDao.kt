package com.madreapps.cocktailcrafter.feature_cocktail.data.data_source

import androidx.room.*
import com.madreapps.cocktailcrafter.feature_cocktail.domain.model.Cocktail
import kotlinx.coroutines.flow.Flow

@Dao
interface CocktailDao {

    @Query("SELECT * FROM cocktail")
    fun getCocktails() : Flow<List<Cocktail>>

    @Query("SELECT * FROM cocktail WHERE id = :id")
    suspend fun getCocktailById(id: Int): Cocktail?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCocktail(cocktail: Cocktail)

    @Delete
    suspend fun deleteCocktail(cocktail: Cocktail)
}