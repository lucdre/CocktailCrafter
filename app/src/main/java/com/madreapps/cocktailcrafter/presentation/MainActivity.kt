package com.madreapps.cocktailcrafter.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.madreapps.cocktailcrafter.presentation.ui.theme.CocktailCrafterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CocktailCrafterTheme {
                Surface(color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}