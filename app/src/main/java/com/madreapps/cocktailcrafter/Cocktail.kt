package com.madreapps.cocktailcrafter

/**
 * Author: Luca Thiel
 * 19.10.21
 */
var cocktailList = mutableListOf<Cocktail>()

val COCKTAIL_ID_EXTRA = "cocktailExtra"

// A Cocktail has an image, a name, the base spirit, a description (for now) and an incrementing ID
class Cocktail (
    var image: Int,
    var name: String,
    var baseSpirit: String,
    var description: String,
    val id: Int? = cocktailList.size
)