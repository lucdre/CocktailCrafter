package com.madreapps.cocktailcrafter.feature_cocktail.presentation.cocktails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.madreapps.cocktailcrafter.feature_cocktail.domain.model.Cocktail
import com.madreapps.cocktailcrafter.feature_cocktail.domain.use_case.CocktailUseCases
import com.madreapps.cocktailcrafter.feature_cocktail.domain.util.CocktailOrder
import com.madreapps.cocktailcrafter.feature_cocktail.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CocktailsViewModel @Inject constructor(
    private val cocktailUseCases: CocktailUseCases
) : ViewModel() {

    private val _state = mutableStateOf(CocktailsState())
    val state: State<CocktailsState> = _state

    private var recentlyDeletedCocktail: Cocktail? = null

    private var getCocktailsJob: Job? = null

    init {
        getCocktails(CocktailOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: CocktailsEvent) {
        when (event) {
            is CocktailsEvent.Order -> {
                if (state.value.cocktailOrder::class == event.cocktailOrder::class &&
                    state.value.cocktailOrder.orderType == event.cocktailOrder.orderType
                ) {
                    return
                }
                getCocktails(event.cocktailOrder)
            }
            is CocktailsEvent.DeleteCocktail -> {
                viewModelScope.launch {
                    cocktailUseCases.deleteCocktails(event.cocktail)
                    recentlyDeletedCocktail = event.cocktail
                }
            }
            is CocktailsEvent.RestoreCocktail -> {
                viewModelScope.launch {
                    cocktailUseCases.addCocktail(recentlyDeletedCocktail ?: return@launch)
                    recentlyDeletedCocktail = null
                }
            }
            is CocktailsEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getCocktails(cocktailOrder: CocktailOrder) {
        getCocktailsJob?.cancel()
        getCocktailsJob = cocktailUseCases.getCocktails(cocktailOrder)
            .onEach { cocktails ->
                _state.value = state.value.copy(
                    cocktails = cocktails,
                    cocktailOrder = cocktailOrder
                )
            }
            .launchIn(viewModelScope)
    }

}