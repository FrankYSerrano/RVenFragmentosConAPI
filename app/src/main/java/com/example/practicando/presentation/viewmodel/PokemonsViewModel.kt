package com.example.practicando.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicando.data.response.Pokemon
import com.example.practicando.data.response.PokemonResponse
import com.example.practicando.domain.PokemonsUseCase
import kotlinx.coroutines.launch

class PokemonsViewModel (private val pokemonsUseCase: PokemonsUseCase): ViewModel() {

    private val pokemonsList = MutableLiveData<MutableList<Pokemon>>()

    val pokemonLV
        get() = pokemonsList
    init {
        viewModelScope.launch {
            pokemonsList.value = pokemonsUseCase.getAllPokemons()
            Log.i("FRANK", "PokemonsViewModel: ${pokemonsList.value}")
        }
    }
}