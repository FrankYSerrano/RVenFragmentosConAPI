package com.example.practicando.data.network.api

import com.example.practicando.data.network.retrofit.RetrofitHelper
import com.example.practicando.data.response.Pokemon
import com.example.practicando.data.response.PokemonResponse

class PokemonApiClient {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getPokemonList(): MutableList<Pokemon> {
        val response = retrofit.create(PokemonService::class.java).getAllPokemons()
        return response
    }

}