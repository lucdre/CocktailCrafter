package com.madreapps.cocktailcrafter.domain.use_case.get_cocktail

import com.madreapps.cocktailcrafter.common.Resource
import com.madreapps.cocktailcrafter.data.remote.dto.toCocktail
import com.madreapps.cocktailcrafter.data.remote.dto.toCocktailDetail
import com.madreapps.cocktailcrafter.domain.model.Cocktail
import com.madreapps.cocktailcrafter.domain.model.CocktailDetail
import com.madreapps.cocktailcrafter.domain.repository.CocktailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetCocktailUseCase @Inject constructor(
    private val repository: CocktailRepository
) {
    //IF we would get this from an actual API also add catch HttpException
    operator fun invoke(cocktailId: String): Flow<Resource<CocktailDetail>> = flow {
        try {
            emit(Resource.Loading())
            val cocktail = repository.getCocktailByID(cocktailId).toCocktailDetail()
            emit(Resource.Success(cocktail))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Check your internet :("))
        }
    }
}