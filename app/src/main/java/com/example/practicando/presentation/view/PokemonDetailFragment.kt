package com.example.practicando.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.practicando.R
import com.example.practicando.data.response.Pokemon
import com.example.practicando.databinding.FragmentPokemonDetailsBinding

class PokemonDetailFragment: Fragment(){

    private lateinit var binding: FragmentPokemonDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentPokemonDetailsBinding.inflate(inflater, container, false)
//        val pokemon = arguments?.getParcelable<Pokemon>("pokemon")

//        binding.TVPokemonName.text = pokemon?.name
//        binding.TVPokemonCategory.text = pokemon?.category
//        binding.TVPokemonURL.text = pokemon?.url


        return binding.root
    }

}