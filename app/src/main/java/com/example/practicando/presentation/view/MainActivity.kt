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
    private lateinit var viewModel: PokemonsViewModel
    private lateinit var adapterPokemonList: PokemonListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupRecyclerView()

        cargarFragmentList()
        cargarFragmentDetail()

    }

    private fun setupViewModel() {
        val apiService = RetrofitHelper.getRetrofit()
            .create(PokemonService::class.java)
        val repository = PokemonRepositoryImplementation(apiService)
        val useCase = PokemonsUseCase(repository)
        val viewmodelFactory = PokemonsViewmodelFactory(useCase)
        val viewModel = ViewModelProvider(this, viewmodelFactory)
            .get(PokemonsViewModel::class.java)
    }

    private fun setupRecyclerView() {
        adapterPokemonList = PokemonListAdapter()
//        binding.recyclerView.adapter = adapterPokemonList
    }

    private fun cargarFragmentList() {
        val fragmentList = PokemonListFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.FL_List, fragmentList)
            .commit()
    }

    private fun cargarFragmentDetail(){
    }

}