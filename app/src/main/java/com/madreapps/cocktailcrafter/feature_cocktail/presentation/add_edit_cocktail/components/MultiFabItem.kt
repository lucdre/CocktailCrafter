package com.madreapps.cocktailcrafter.feature_cocktail.presentation.add_edit_cocktail.components

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * @param id Cannot be duplicated with the [id] value of another [MultiFabItem].
 */
data class MultiFabItem(
    val id: Int,
    val iconRes: ImageVector,
    val label: String = ""
)