package com.example.practicando.data.repository

import com.example.practicando.data.response.Pokemon
import com.example.practicando.data.response.PokemonResponse

interface PokemonRepository {
//    suspend fun fetchPokemons(): MutableList<PokemonResponse>
    suspend fun fetchPokemons(): MutableList<Pokemon>
}