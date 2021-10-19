package com.madreapps.cocktailcrafter

/**
 * Author: Luca Thiel
 * 19.10.21
 */
import androidx.recyclerview.widget.RecyclerView
import com.madreapps.cocktailcrafter.databinding.CardCellBinding

// The viewHolder, binds the cocktails to the card
class CardViewHolder(
    private val cardCellBinding: CardCellBinding,
    private val clickListener: CocktailClickListener
) : RecyclerView.ViewHolder(cardCellBinding.root) {

    fun bindCocktail(cocktail: Cocktail) {
        cardCellBinding.cocktailImage.setImageResource(cocktail.image)
        cardCellBinding.cocktailName.text = cocktail.name
        cardCellBinding.baseSpirit.text = cocktail.baseSpirit

        cardCellBinding.cardView.setOnClickListener{
            clickListener.onClick(cocktail)
        }
    }
}