package com.example.practicando.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practicando.data.response.Pokemon
import com.example.practicando.databinding.ItemPokemonBinding

class PokemonListAdapter: RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder>(){

    lateinit var onItemClickListener: (Pokemon) -> Unit

    var pokemons = mutableListOf<Pokemon>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): PokemonViewHolder {

        val bindingItem =
            ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(bindingItem)
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int {
        return pokemons.size
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the [ViewHolder.itemView] to reflect the item at the given
     * position.
     *
     *
     * Note that unlike [android.widget.ListView], RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the `position` parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use [ViewHolder.getAdapterPosition] which will
     * have the updated adapter position.
     *
     * Override [.onBindViewHolder] instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     * item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemons[position]
        holder.bind(pokemon)
    }

    inner class PokemonViewHolder(var bindingItem: ItemPokemonBinding)
        : RecyclerView.ViewHolder(bindingItem.root) {
            fun bind(pokemon: Pokemon){
                with(pokemon){
                    bindingItem.TVPokemonName.text = name
//                    bindingItem.IVPokemonMini.setImageResource()
                }
            }
    }

}

