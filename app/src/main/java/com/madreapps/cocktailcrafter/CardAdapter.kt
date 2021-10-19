package com.madreapps.cocktailcrafter

/**
 * Author: Luca Thiel
 * 19.10.21
 */
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.madreapps.cocktailcrafter.databinding.CardCellBinding

// The adapter
class CardAdapter(private val cocktails: List<Cocktail>)
    : RecyclerView.Adapter<CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = CardCellBinding.inflate(from, parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bindCocktail(cocktails[position])
    }

    override fun getItemCount(): Int = cocktails.size
}