package com.example.practicando.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practicando.domain.PokemonsUseCase

class PokemonsViewmodelFactory (private val pokemonsUseCase: PokemonsUseCase): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(PokemonsViewModel::class.java)) {
            return PokemonsViewModel(pokemonsUseCase) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}