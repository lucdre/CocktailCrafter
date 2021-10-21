package com.madreapps.cocktailcrafter.data.remote.dto

import com.madreapps.cocktailcrafter.domain.model.CocktailDetail

//TODO add description to both
data class CocktailDetailDTO(
    val id: String,
    val image: Int,
    val name: String,
    val baseSpirit: String,
    val ingredients: String,
    val steps: String
)

fun CocktailDetailDTO.toCocktailDetail(): CocktailDetail {
    return CocktailDetail(
        id = id,
        image = image,
        name = name,
        baseSpirit = baseSpirit,
        ingredients = ingredients,
        steps = steps
    )
}