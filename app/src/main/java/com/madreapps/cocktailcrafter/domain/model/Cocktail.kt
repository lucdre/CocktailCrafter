package com.madreapps.cocktailcrafter.domain.model

/**
 * Author: Luca Thiel
 * 21.10.21
 */

data class Cocktail(
    val id: String,
    val image: Int,
    val name: String,
    val baseSpirit: String,
    //val ingredients: String,
    //val steps: String
)