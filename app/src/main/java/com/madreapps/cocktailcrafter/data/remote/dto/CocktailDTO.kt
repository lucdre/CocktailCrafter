package com.madreapps.cocktailcrafter.data.remote.dto

import com.madreapps.cocktailcrafter.domain.model.Cocktail

data class CocktailDTO(
    val id: String,
    val image: Int,
    val name: String,
    val baseSpirit: String,
    //val ingredients: String,
    //val steps: String
)

fun CocktailDTO.toCocktail(): Cocktail {
    return Cocktail(
        id = id,
        image = image,
        name = name,
        baseSpirit = baseSpirit,
        //ingredients = ingredients,
        //steps = steps
    )
}