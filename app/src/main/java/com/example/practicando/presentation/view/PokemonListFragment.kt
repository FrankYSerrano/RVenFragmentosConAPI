package com.example.practicando.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicando.R
import com.example.practicando.data.response.Pokemon
import com.example.practicando.databinding.FragmentPokemonListBinding
import com.example.practicando.presentation.viewmodel.PokemonsViewModel

class PokemonListFragment(): Fragment(){
//class PokemonListFragment(private val pokemonList: MutableLiveData<MutableList<Pokemon>>): Fragment() {
    // Implementación del fragmento

    private lateinit var binding: FragmentPokemonListBinding
    private val pokemonListAdapter = PokemonListAdapter()
    private val pokemonsViewModel: PokemonsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("XXX", "onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("XXX", "onCreateView")
        binding = FragmentPokemonListBinding.inflate(inflater, container, false)
        initAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i("XXX", "onViewCreated")
        val navController = Navigation.findNavController(view)
        pokemonListAdapter.onItemClickListener = { pokemon ->
            Toast.makeText(requireContext(), pokemon.name, Toast.LENGTH_SHORT).show()

            val bundle = Bundle().apply {
                putString("name", pokemon.name)
                //Aca agrega mas cosas para enviar al otro fragmento
            }
            navController.navigate(R.id.action_pokemonListFragment_to_pokemonDetailFragment, bundle)
        }
//        pokemonsViewModel.pokemonLV.observe(viewLifecycleOwner, Observer { pokemons ->
//            pokemonListAdapter.pokemons = pokemons ?: mutableListOf() // Provide an empty list if null
//        })
    }

    fun getPokemons(): MutableList<Pokemon> {
        val pokemons = mutableListOf<Pokemon>(
            Pokemon("Bulbasaur", "Grass"),
            Pokemon("Charmander", "Fire"),
            Pokemon("Squirtle", "Water"),
            Pokemon("Pikachu", "Electric"),
            Pokemon("Mew", "Psychic"),
            Pokemon("Caterpie", "Bug"),
            Pokemon("Weedle", "Bug"),
            Pokemon("Pidgey", "Normal"),
            Pokemon("Rattata", "Normal"),
            Pokemon("Spearow", "Flying"),
            Pokemon("Ekans", "Poison"),
            Pokemon("Arbok", "Poison"),
            Pokemon("Jigglypuff", "Normal"),
            Pokemon("Meowth", "Normal"),
            Pokemon("Psyduck", "Water"),
            Pokemon("Golduck", "Water"),
            Pokemon("Growlithe", "Fire"),
            Pokemon("Arcanine", "Fire")
        )
        return pokemons
    }

    fun initAdapter() {
        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewPokemons.layoutManager = linearLayoutManager
//        val pokemonsList = pokemonList
//        pokemonListAdapter.pokemons = pokemonsList.value!!
        pokemonListAdapter.pokemons = getPokemons()
//        pokemonListAdapter.pokemons = PokemonsViewModel.pokemonLV
        binding.recyclerViewPokemons.adapter = pokemonListAdapter
    }


}