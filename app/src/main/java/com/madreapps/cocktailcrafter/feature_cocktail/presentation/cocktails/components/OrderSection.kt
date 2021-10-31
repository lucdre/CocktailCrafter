package com.madreapps.cocktailcrafter.feature_cocktail.presentation.cocktails.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.madreapps.cocktailcrafter.feature_cocktail.domain.util.CocktailOrder
import com.madreapps.cocktailcrafter.feature_cocktail.domain.util.OrderType

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    cocktailOrder: CocktailOrder = CocktailOrder.Date(OrderType.Descending),
    onOrderChange: (CocktailOrder) -> Unit
) {
    Column (
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = "Title",
                selected = cocktailOrder is CocktailOrder.Title,
                onSelect = { onOrderChange(CocktailOrder.Title(cocktailOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Date",
                selected = cocktailOrder is CocktailOrder.Date,
                onSelect = { onOrderChange(CocktailOrder.Date(cocktailOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Base Spirit",
                selected = cocktailOrder is CocktailOrder.BaseSpirit,
                onSelect = { onOrderChange(CocktailOrder.BaseSpirit(cocktailOrder.orderType)) }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = "Ascending",
                selected = cocktailOrder.orderType is OrderType.Ascending,
                onSelect = { onOrderChange(cocktailOrder.copy(OrderType.Ascending)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Descending",
                selected = cocktailOrder.orderType is OrderType.Descending,
                onSelect = { onOrderChange(cocktailOrder.copy(OrderType.Descending)) }
            )
        }
    }

}