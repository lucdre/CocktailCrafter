package com.madreapps.cocktailcrafter.feature_cocktail.presentation.add_edit_cocktail

import androidx.compose.ui.focus.FocusState

sealed class AddEditCocktailEvent {
    data class EnteredTitle(val value: String): AddEditCocktailEvent()
    data class ChangeTitleFocus(val focusState: FocusState): AddEditCocktailEvent()
    data class EnteredContent(val value: String): AddEditCocktailEvent()
    data class ChangeContentFocus(val focusState: FocusState): AddEditCocktailEvent()
    data class ChangeColor(val color: Int): AddEditCocktailEvent()
    object SaveCocktail: AddEditCocktailEvent()
}
