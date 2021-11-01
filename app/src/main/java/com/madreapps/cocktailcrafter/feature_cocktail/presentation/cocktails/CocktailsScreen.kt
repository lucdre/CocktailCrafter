package com.madreapps.cocktailcrafter.feature_cocktail.presentation.cocktails

import androidx.compose.animation.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Sort
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.madreapps.cocktailcrafter.feature_cocktail.presentation.cocktails.components.CocktailItem
import com.madreapps.cocktailcrafter.feature_cocktail.presentation.cocktails.components.OrderSection
import com.madreapps.cocktailcrafter.feature_cocktail.presentation.util.Screen
import kotlinx.coroutines.launch

//TODO remove option of editing when clicking, and remove delete button
@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun CocktailsScreen(
    navController: NavController,
    viewModel: CocktailsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.AddEditCocktailScreen.route)
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add cocktail")
            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Cocktails",
                    style = MaterialTheme.typography.h4
                )
                IconButton(
                    onClick = {
                        viewModel.onEvent(CocktailsEvent.ToggleOrderSection)
                    },
                ) {
                   Icon(
                       imageVector = Icons.Default.Sort,
                       contentDescription = "Sort"
                   )
                }
            }
            AnimatedVisibility(
                visible = state.isOrderSectionVisible,
                enter = fadeIn() + slideInVertically(),
                exit = fadeOut() + slideOutVertically()
            ) {
                OrderSection(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    cocktailOrder = state.cocktailOrder,
                    onOrderChange = {
                        viewModel.onEvent(CocktailsEvent.Order(it))
                    }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            //TODO somehow adapt to the size once added image, also the gridview (like pinterest)
            LazyVerticalGrid(
                cells = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.cocktails) { cocktail ->
                    CocktailItem(
                        cocktail = cocktail,
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                navController.navigate(
                                    Screen.AddEditCocktailScreen.route +
                                            "?cocktailId=${cocktail.id}&cocktailColor=${cocktail.color}"
                                )
                            },
                        onDeleteClick = {
                            viewModel.onEvent(CocktailsEvent.DeleteCocktail(cocktail))
                            scope.launch {
                                val result = scaffoldState.snackbarHostState.showSnackbar(
                                    message = "Cocktail deleted",
                                    actionLabel = "Undo"
                                )
                                if(result == SnackbarResult.ActionPerformed) {
                                    viewModel.onEvent(CocktailsEvent.RestoreCocktail)
                                }
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}