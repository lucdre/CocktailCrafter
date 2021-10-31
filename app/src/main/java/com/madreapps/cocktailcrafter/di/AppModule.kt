package com.madreapps.cocktailcrafter.di

import android.app.Application
import androidx.room.Room
import com.madreapps.cocktailcrafter.feature_cocktail.data.data_source.CocktailDatabase
import com.madreapps.cocktailcrafter.feature_cocktail.data.repository.CocktailRepositoryImpl
import com.madreapps.cocktailcrafter.feature_cocktail.domain.repository.CocktailRepository
import com.madreapps.cocktailcrafter.feature_cocktail.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCocktailDatabase(app: Application): CocktailDatabase {
        return Room.databaseBuilder(
            app,
            CocktailDatabase::class.java,
            CocktailDatabase.DATABASE_NAME
        ).build()
    }

    //For test cases, in a different module we can change the repository
    @Provides
    @Singleton
    fun provideCocktailRepository(db: CocktailDatabase): CocktailRepository {
        return CocktailRepositoryImpl(db.cocktailDao)
    }

    @Provides
    @Singleton
    fun provideCocktailUseCases(repository: CocktailRepository): CocktailUseCases {
        return CocktailUseCases(
            getCocktails = GetCocktailsUseCase(repository),
            deleteCocktail = DeleteCocktailUseCase(repository),
            addCocktail = AddCocktailUseCase(repository),
            getCocktail = GetCocktailUseCase(repository)
        )
    }

}