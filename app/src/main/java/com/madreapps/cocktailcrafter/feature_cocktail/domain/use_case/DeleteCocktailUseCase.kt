package com.madreapps.cocktailcrafter.feature_cocktail.domain.use_case

import com.madreapps.cocktailcrafter.feature_cocktail.domain.model.Cocktail
import com.madreapps.cocktailcrafter.feature_cocktail.domain.repository.CocktailRepository

class DeleteCocktailUseCase(
    private val repository: CocktailRepository
) {

    suspend operator fun invoke(cocktail: Cocktail) {
        repository.deleteCocktail(cocktail)
    }
}