package com.madreapps.cocktailcrafter.feature_cocktail.domain.use_case

data class CocktailUseCases(
    val getCocktails: GetCocktailsUseCase,
    val deleteCocktails: DeleteCocktailUseCase,
    val addCocktail: AddCocktailUseCase
)
