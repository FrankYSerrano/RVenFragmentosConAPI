package com.example.practicando.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.practicando.R
import com.example.practicando.data.network.api.PokemonService
import com.example.practicando.data.network.retrofit.RetrofitHelper
import com.example.practicando.data.repository.PokemonRepositoryImplementation
import com.example.practicando.databinding.ActivityMainBinding
import com.example.practicando.domain.PokemonsUseCase
import com.example.practicando.presentation.viewmodel.PokemonsViewModel
import com.example.practicando.presentation.viewmodel.PokemonsViewmodelFactory

//import androidx.fragment.app.Fragment
//import androidx.fragment.app.FragmentManager
//import com.example.practicando.databinding.FragmentPokemonListBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var apiService: PokemonService
    private lateinit var repository: PokemonRepositoryImplementation
    private lateinit var useCase: PokemonsUseCase
    private lateinit var viewModelFactory : PokemonsViewmodelFactory
    private lateinit var mainViewModel : PokemonsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        apiService = RetrofitHelper.getRetrofit()
//            .create(PokemonService::class.java)
//        repository = PokemonRepositoryImplementation(apiService)
//        useCase = PokemonsUseCase(repository)
//        viewModelFactory = PokemonsViewmodelFactory(useCase)
//        mainViewModel = ViewModelProvider(this, viewModelFactory)[PokemonsViewModel::class.java]

//        if (savedInstanceState == null) {
//            cargarFragmentList()
//        }
//        cargarFragmentDetail()
    }

    private fun cargarFragmentList() {
        val fragmentList = PokemonListFragment()
//        val fragmentList = PokemonListFragment(mainViewModel.pokemonLV)
        supportFragmentManager.beginTransaction()
            .replace(R.id.FCV_main, fragmentList) // Ensure the ID matches your layout
            .commit()
    }

    private fun cargarFragmentDetail(){
    }

}