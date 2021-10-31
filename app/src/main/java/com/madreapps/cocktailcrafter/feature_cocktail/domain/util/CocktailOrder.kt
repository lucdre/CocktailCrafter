package com.madreapps.cocktailcrafter.feature_cocktail.domain.util

sealed class CocktailOrder(val orderType: OrderType) {
    class Title(orderType: OrderType): CocktailOrder(orderType)
    class Date(orderType: OrderType): CocktailOrder(orderType)
    class BaseSpirit(orderType: OrderType): CocktailOrder(orderType)
}
