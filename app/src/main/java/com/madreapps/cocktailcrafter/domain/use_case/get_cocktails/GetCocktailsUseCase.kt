package com.madreapps.cocktailcrafter.domain.use_case.get_cocktails

import com.madreapps.cocktailcrafter.common.Resource
import com.madreapps.cocktailcrafter.data.remote.dto.toCocktail
import com.madreapps.cocktailcrafter.domain.model.Cocktail
import com.madreapps.cocktailcrafter.domain.repository.CocktailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetCocktailsUseCase @Inject constructor(
    private val repository: CocktailRepository
) {
    //IF we would get this from an actual API also add catch HttpException
    operator fun invoke(): Flow<Resource<List<Cocktail>>> = flow {
        try {
            emit(Resource.Loading())
            val cocktails = repository.getCocktails().map { it.toCocktail() }
            emit(Resource.Success(cocktails))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Check your internet :("))
        }
    }
}