package com.madreapps.cocktailcrafter.presentation.cocktail_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.madreapps.cocktailcrafter.domain.model.Cocktail

@Composable
fun CocktailListItem(
    cocktail: Cocktail,
    onItemClick: (Cocktail) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(cocktail) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

    }
}