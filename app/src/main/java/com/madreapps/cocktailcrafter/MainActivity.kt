package com.madreapps.cocktailcrafter

/**
 * Author: Luca Thiel
 * 15.10.21
 */
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
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
            layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
            adapter = CardAdapter(cocktailList, mainActivity)
        }

    }

    /**
     * Temporary solution, (I hope) to issue#2  https://github.com/lucdre/CocktailCrafter/issues/2
     */
    //TODO test this, also probably not the best idea to clear and re-populate everytime
    override fun onBackPressed() {
        super.onBackPressed()
        cocktailList.clear()
    }

    override fun onClick(cocktail: Cocktail) {
        val intent = Intent(applicationContext, DetailActivity::class.java)
        intent.putExtra(COCKTAIL_ID_EXTRA, cocktail.id)
        startActivity(intent)
    }

    private fun populateCocktails(){
        val goldRush = Cocktail(
            R.drawable.goldrush,
            "Gold Rush",
            getString(R.string.BSBourbon),
            getString(R.string.GRIngredients),
            getString(R.string.GRSteps)
        )
        cocktailList.add(goldRush)

        val xyz = Cocktail(
            R.drawable.xyz,
            "X.Y.Z.",
            getString(R.string.BSRum),
            getString(R.string.XYZIngredients),
            getString(R.string.XYZSteps)
        )
        cocktailList.add(xyz)

        val miamiCocktail = Cocktail(
            R.drawable.miamicocktail,
            "Miami Cocktail",
            getString(R.string.BSWRum),
            getString(R.string.MCIngredients),
            getString(R.string.MCSteps)
        )
        cocktailList.add(miamiCocktail)

        val daiquiri = Cocktail(
            R.drawable.daiquiri,
            "Daiquiri",
            getString(R.string.BSWRum),
            getString(R.string.DaiquiriIngredients),
            getString(R.string.DaiquiriSteps)
        )
        cocktailList.add(daiquiri)

        val mojito = Cocktail(
            R.drawable.mojito,
            "Mojito",
            getString(R.string.BSWRum),
            getString(R.string.MojitoIngredients),
            getString(R.string.MojitoSteps)
        )
        cocktailList.add(mojito)

        val tarin = Cocktail(
            R.drawable.placeholder,
            "El Tarin",
            getString(R.string.BSBourbon),
            getString(R.string.TarinIngredients),
            getString(R.string.TarinSteps)
        )
        cocktailList.add(tarin)

        val manhattan = Cocktail(
            R.drawable.manhattan,
            "Manhattan",
            getString(R.string.BSBourbon),
            getString(R.string.ManhattanIngredients),
            getString(R.string.ManhattanSteps)
        )
        cocktailList.add(manhattan)

        val oldFashioned = Cocktail(
            R.drawable.oldie,
            "Old Fashioned",
            getString(R.string.BSBourbon),
            getString(R.string.OldieIngredients),
            getString(R.string.OldieSteps)
        )
        cocktailList.add(oldFashioned)

        val cRickey = Cocktail(
            R.drawable.crickey,
            "Cointreau Rickey",
            getString(R.string.Cointreau),
            getString(R.string.CRickeyIngredients),
            getString(R.string.CRickeySteps)
        )
        cocktailList.add(cRickey)

        val cCocktail = Cocktail(
            R.drawable.ccocktail,
            "Cointreau Cocktail",
            getString(R.string.Cointreau),
            getString(R.string.CCocktailIngredients),
            getString(R.string.CCocktailSteps)
        )
        cocktailList.add(cCocktail)

        val jMule = Cocktail(
            R.drawable.placeholder,
            "Jäger Mule",
            getString(R.string.BSJäger),
            getString(R.string.JMuleIngredients),
            getString(R.string.JMuleSteps)
        )
        cocktailList.add(jMule)

        val margarita = Cocktail(
            R.drawable.placeholder,
            "Margarita",
            getString(R.string.BSTequila),
            getString(R.string.MargaritaIngredients),
            getString(R.string.MargaritaSteps)
        )
        cocktailList.add(margarita)

        val wSour = Cocktail(
            R.drawable.placeholder,
            "Whisky Sour",
            getString(R.string.BSBourbon),
            getString(R.string.WSourIngredients),
            getString(R.string.WSourSteps)
        )
        cocktailList.add(wSour)

        val penicillin = Cocktail(
            R.drawable.placeholder,
            "Penicillin",
            getString(R.string.BSScotch),
            getString(R.string.PenicillinIngredients),
            getString(R.string.PenicillinSteps)
        )
        cocktailList.add(penicillin)


    }
}