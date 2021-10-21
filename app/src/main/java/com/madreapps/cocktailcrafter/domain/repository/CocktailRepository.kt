package com.madreapps.cocktailcrafter.domain.repository

import com.madreapps.cocktailcrafter.data.remote.dto.CocktailDTO
import com.madreapps.cocktailcrafter.data.remote.dto.CocktailDetailDTO

interface CocktailRepository {

    suspend fun getCocktails() : List<CocktailDTO>

    suspend fun getCocktailByID(cocktailID: String) : CocktailDetailDTO
}