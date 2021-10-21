package com.madreapps.cocktailcrafter.domain.model

//TODO add description
data class CocktailDetail(
    val id: String,
    val image: Int,
    val name: String,
    val baseSpirit: String,
    val ingredients: String,
    val steps: String
)