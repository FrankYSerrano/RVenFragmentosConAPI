package com.example.practicando.data.network.api

import com.example.practicando.data.response.Pokemon
import com.example.practicando.data.response.PokemonResponse
import retrofit2.http.GET

interface PokemonService {
    @GET("pokemon")
//    suspend fun getAllPokemons(): MutableList<PokemonResponse>
    suspend fun getAllPokemons(): MutableList<Pokemon>

}