package com.madreapps.cocktailcrafter.presentation.cocktail_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.madreapps.cocktailcrafter.common.Resource
import com.madreapps.cocktailcrafter.domain.use_case.get_cocktails.GetCocktailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CocktailListViewModel @Inject constructor(
    private val getCocktailsUseCase: GetCocktailsUseCase
) : ViewModel() {

    private val _state = mutableStateOf<CocktailListState>(CocktailListState())
    val state: State<CocktailListState> = _state

    init {
        getCocktails()
    }

    private fun getCocktails() {
        getCocktailsUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CocktailListState(cocktails = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CocktailListState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = CocktailListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}