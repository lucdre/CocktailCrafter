package com.madreapps.cocktailcrafter

/**
 * Author: Luca Thiel
 * 15.10.21
 */
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.madreapps.cocktailcrafter.databinding.ActivityMainBinding

// We define the standard cocktails
class MainActivity : AppCompatActivity(), CocktailClickListener {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        populateCocktails()

        val mainActivity = this
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(applicationContext, 3)
            adapter = CardAdapter(cocktailList, mainActivity)
        }
    }

    override fun onClick(cocktail: Cocktail) {
        val intent = Intent(applicationContext, DetailActivity::class.java)
        intent.putExtra(COCKTAIL_ID_EXTRA, cocktail.id)
        startActivity(intent)
    }

    private fun populateCocktails(){
        val cocktail1 = Cocktail(
            R.drawable.goldrush,
            "Gold Rush",
            "Rum",
            "Nice gold rushlike hehetest"
        )
        cocktailList.add(cocktail1)

        val cocktail2 = Cocktail(
            R.drawable.xyz,
            "X.Y.Z.",
            "Rum",
            "Nice rummmmm"
        )
        cocktailList.add(cocktail2)

        val cocktail3 = Cocktail(
            R.drawable.miamicocktail,
            "Miami Cocktail",
            "White Rum",
            "Nice white ruuummmmm"
        )
        cocktailList.add(cocktail3)

    }
}