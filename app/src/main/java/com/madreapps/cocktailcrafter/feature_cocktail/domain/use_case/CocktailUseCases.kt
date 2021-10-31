package com.madreapps.cocktailcrafter.feature_cocktail.domain.use_case

data class CocktailUseCases(
    val getCocktails: GetCocktailsUseCase,
    val deleteCocktail: DeleteCocktailUseCase,
    val addCocktail: AddCocktailUseCase,
    val getCocktail: GetCocktailUseCase
)
