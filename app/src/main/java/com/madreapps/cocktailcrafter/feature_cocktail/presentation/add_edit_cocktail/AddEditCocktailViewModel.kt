package com.madreapps.cocktailcrafter.feature_cocktail.presentation.add_edit_cocktail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.madreapps.cocktailcrafter.feature_cocktail.domain.model.Cocktail
import com.madreapps.cocktailcrafter.feature_cocktail.domain.model.InvalidCocktailException
import com.madreapps.cocktailcrafter.feature_cocktail.domain.use_case.CocktailUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditCocktailViewModel @Inject constructor(
    private val cocktailUseCases: CocktailUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _cocktailTitle = mutableStateOf(CocktailTextFieldState(
        hint = "Enter title..."
    ))
    val cocktailTitle: State<CocktailTextFieldState> = _cocktailTitle

    private val _cocktailContent = mutableStateOf(CocktailTextFieldState(
        hint = "Enter some content..."
    ))
    val cocktailContent: State<CocktailTextFieldState> = _cocktailContent

    private val _cocktailColor = mutableStateOf(Cocktail.cocktailColors.random().toArgb())
    val cocktailColor: State<Int> = _cocktailColor

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentCocktailId: Int? = null

    init {
        savedStateHandle.get<Int>("cocktailId")?.let { cocktailId ->
            if(cocktailId != -1) {
                viewModelScope.launch {
                    cocktailUseCases.getCocktail(cocktailId)?.also { cocktail ->
                        currentCocktailId = cocktail.id
                        _cocktailTitle.value = cocktailTitle.value.copy(
                            text = cocktail.title,
                            isHintVisible = false
                        )
                        _cocktailContent.value = cocktailContent.value.copy(
                            text = cocktail.content,
                            isHintVisible = false
                        )
                        _cocktailColor.value = cocktail.color
                    }
                }
            }
        }
    }

    fun onEvent(event: AddEditCocktailEvent) {
        when(event) {
            is AddEditCocktailEvent.EnteredTitle -> {
                _cocktailTitle.value = cocktailTitle.value.copy(
                    text = event.value
                )
            }
            is AddEditCocktailEvent.ChangeTitleFocus -> {
                _cocktailTitle.value = cocktailTitle.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            cocktailTitle.value.text.isBlank()
                )
            }
            is AddEditCocktailEvent.EnteredContent -> {
                _cocktailContent.value = cocktailContent.value.copy(
                    text = event.value
                )
            }
            is AddEditCocktailEvent.ChangeContentFocus -> {
                _cocktailContent.value = cocktailContent.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            cocktailContent.value.text.isBlank()
                )
            }
            is AddEditCocktailEvent.ChangeColor -> {
                _cocktailColor.value = event.color
            }
            is AddEditCocktailEvent.SaveCocktail -> {
                viewModelScope.launch {
                    try {
                        cocktailUseCases.addCocktail(
                            Cocktail(
                                //TODO baseSpirit
                                title = cocktailTitle.value.text,
                                baseSpirit = "BSPlaceholder",
                                content = cocktailContent.value.text,
                                timestamp = System.currentTimeMillis(),
                                color = cocktailColor.value,
                                id = currentCocktailId
                            )
                        )
                        _eventFlow.emit(UiEvent.SaveCocktail)
                    } catch(e: InvalidCocktailException) {
                        _eventFlow.emit(
                            UiEvent.ShowSnackbar(
                                message = e.message ?: "Couldn't save cocktail"
                            )
                        )
                    }
                }
            }
        }
    }

    sealed class UiEvent {
        data class ShowSnackbar(val message: String): UiEvent()
        object SaveCocktail: UiEvent()
    }

}