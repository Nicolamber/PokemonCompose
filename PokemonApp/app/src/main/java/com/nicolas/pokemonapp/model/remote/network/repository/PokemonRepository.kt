package com.nicolas.pokemonapp.model.remote.network.repository

import com.nicolas.pokemonapp.model.remote.network.PokeApi
import com.nicolas.pokemonapp.model.remote.responses.Pokemon
import com.nicolas.pokemonapp.model.remote.responses.PokemonList
import com.nicolas.pokemonapp.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An error occurred.")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An error occurred.")
        }
        return Resource.Success(response)
    }
}
