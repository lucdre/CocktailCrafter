package com.madreapps.cocktailcrafter.feature_cocktail.domain.use_case

import com.madreapps.cocktailcrafter.feature_cocktail.domain.model.Cocktail
import com.madreapps.cocktailcrafter.feature_cocktail.domain.model.InvalidCocktailException
import com.madreapps.cocktailcrafter.feature_cocktail.domain.repository.CocktailRepository

class AddCocktailUseCase(
    private val repository: CocktailRepository
) {

    @Throws(InvalidCocktailException::class)
    suspend operator fun invoke(cocktail: Cocktail) {
        if(cocktail.title.isBlank()) {
            throw InvalidCocktailException("The title of the cocktail can't be empty.")
        }
        if(cocktail.content.isBlank()) {
            throw InvalidCocktailException("The content of the cocktail can't be empty.")
        }
        repository.insertCocktail(cocktail)
    }
}