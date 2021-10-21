package com.madreapps.cocktailcrafter.data.repository

import com.madreapps.cocktailcrafter.data.remote.CocktailApi
import com.madreapps.cocktailcrafter.data.remote.dto.CocktailDTO
import com.madreapps.cocktailcrafter.data.remote.dto.CocktailDetailDTO
import com.madreapps.cocktailcrafter.domain.repository.CocktailRepository
import javax.inject.Inject

class CocktailRepositoryImpl @Inject constructor(
    private val api : CocktailApi
) : CocktailRepository {

    override suspend fun getCocktails(): List<CocktailDTO> {
        return api.getCocktails()
    }

    override suspend fun getCocktailByID(cocktailID: String): CocktailDetailDTO {
        return api.getCocktailById(cocktailID)
    }

}