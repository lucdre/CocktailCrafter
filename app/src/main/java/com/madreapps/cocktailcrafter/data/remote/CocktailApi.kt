package com.madreapps.cocktailcrafter.data.remote

import com.madreapps.cocktailcrafter.data.remote.dto.CocktailDTO
import com.madreapps.cocktailcrafter.data.remote.dto.CocktailDetailDTO

//TODO not actually an API yet
interface CocktailApi {

    suspend fun getCocktails() : List<CocktailDTO>

    suspend fun getCocktailById(cocktailID: String) : CocktailDetailDTO
}