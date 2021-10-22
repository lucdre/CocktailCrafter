package com.madreapps.cocktailcrafter.di

import com.madreapps.cocktailcrafter.data.remote.CocktailApi
import com.madreapps.cocktailcrafter.data.repository.CocktailRepositoryImpl
import com.madreapps.cocktailcrafter.domain.repository.CocktailRepository
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
    //TODO remove "?" and return correct thing maybe
    fun provideCocktailApi() : CocktailApi? {
        return null
    }

    @Provides
    @Singleton
    fun provideCocktailRepository(api: CocktailApi): CocktailRepository{
        return CocktailRepositoryImpl(api)
    }
}