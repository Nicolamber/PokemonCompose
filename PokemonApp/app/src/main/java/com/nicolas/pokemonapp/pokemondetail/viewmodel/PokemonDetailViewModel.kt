package com.nicolas.pokemonapp.pokemondetail.viewmodel

import androidx.lifecycle.ViewModel
import com.nicolas.pokemonapp.model.remote.network.repository.PokemonRepository
import com.nicolas.pokemonapp.model.remote.responses.Pokemon
import com.nicolas.pokemonapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel()  {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }
}