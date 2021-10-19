package com.madreapps.cocktailcrafter

/**
 * Author: Luca Thiel
 * 19.10.21
 */
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.madreapps.cocktailcrafter.databinding.ActivityDetailBinding

// When you click a card
class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cocktailID = intent.getIntExtra(COCKTAIL_ID_EXTRA, -1)
        val cocktail = cocktailFromID(cocktailID)
        if (cocktail != null) {
            binding.cocktailImage.setImageResource(cocktail.image)
            binding.cocktail.text = cocktail.name
            binding.baseSpirit.text = cocktail.baseSpirit
            binding.description.text = cocktail.description
        }
    }

    private fun cocktailFromID(cocktailID: Int): Cocktail? {
        for (cocktail in cocktailList){
            if (cocktail.id == cocktailID)
                return cocktail
        }
        return null
    }
}