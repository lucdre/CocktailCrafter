package com.madreapps.cocktailcrafter.feature_cocktail.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
