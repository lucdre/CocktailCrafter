package com.madreapps.cocktailcrafter.presentation.cocktail_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.madreapps.cocktailcrafter.common.Constants
import com.madreapps.cocktailcrafter.common.Resource
import com.madreapps.cocktailcrafter.domain.use_case.get_cocktail.GetCocktailUseCase
import com.madreapps.cocktailcrafter.domain.use_case.get_cocktails.GetCocktailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CocktailDetailViewModel @Inject constructor(
    private val getCocktailUseCase: GetCocktailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CocktailDetailState())
    val state: State<CocktailDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COCKTAIL_ID)?.let { cocktailId ->
            getCocktail(cocktailId)
        }
    }

    private fun getCocktail(cocktailId: String) {
        getCocktailUseCase(cocktailId).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CocktailDetailState(cocktail = result.data)
                }
                is Resource.Error -> {
                    _state.value = CocktailDetailState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = CocktailDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}