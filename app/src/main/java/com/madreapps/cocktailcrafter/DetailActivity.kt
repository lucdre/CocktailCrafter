package com.madreapps.cocktailcrafter

/**
 * Author: Luca Thiel
 * 19.10.21
 */
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// When you click a card
class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
}