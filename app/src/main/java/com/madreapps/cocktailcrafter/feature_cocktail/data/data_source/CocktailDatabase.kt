package com.madreapps.cocktailcrafter.feature_cocktail.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.madreapps.cocktailcrafter.feature_cocktail.domain.model.Cocktail

@Database(
    entities = [Cocktail::class],
    version = 1
)
abstract class CocktailDatabase: RoomDatabase() {

    abstract val cocktailDao: CocktailDao

    companion object {
        const val DATABASE_NAME = "cocktails_db"
    }
}