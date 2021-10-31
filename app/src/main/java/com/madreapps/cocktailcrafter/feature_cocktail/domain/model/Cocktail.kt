package com.madreapps.cocktailcrafter.feature_cocktail.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.madreapps.cocktailcrafter.ui.theme.*
import java.lang.Exception

@Entity
data class Cocktail(
    val title: String,
    val baseSpirit: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val cocktailColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidCocktailException(message: String): Exception(message)
