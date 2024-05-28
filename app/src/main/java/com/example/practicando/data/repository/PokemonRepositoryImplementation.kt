package com.example.practicando.data.repository

import com.example.practicando.data.network.api.PokemonService
import com.example.practicando.data.response.Pokemon
import com.example.practicando.data.response.PokemonResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonRepositoryImplementation(private var pokemonService: PokemonService): PokemonRepository {
//    override suspend fun fetchPokemons(): MutableList<PokemonResponse> {
    override suspend fun fetchPokemons(): MutableList<Pokemon> {
        return withContext(Dispatchers.IO){
            val listPokemons = pokemonService.getAllPokemons()
            listPokemons
        }
    }
}