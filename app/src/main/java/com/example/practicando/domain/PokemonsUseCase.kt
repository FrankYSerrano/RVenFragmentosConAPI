package com.example.practicando.domain

import com.example.practicando.data.repository.PokemonRepositoryImplementation
import com.example.practicando.data.response.Pokemon
import com.example.practicando.data.response.PokemonResponse

class PokemonsUseCase (private var pokemonRepositoryImplementation: PokemonRepositoryImplementation) {
    suspend fun getAllPokemons() : MutableList<Pokemon> {
        return pokemonRepositoryImplementation.fetchPokemons()
    }

}