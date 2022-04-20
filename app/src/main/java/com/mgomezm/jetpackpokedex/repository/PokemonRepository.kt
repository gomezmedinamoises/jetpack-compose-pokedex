package com.mgomezm.jetpackpokedex.repository

import com.mgomezm.jetpackpokedex.data.remote.PokeAPI
import com.mgomezm.jetpackpokedex.data.remote.responses.Pokemon
import com.mgomezm.jetpackpokedex.data.remote.responses.PokemonList
import com.mgomezm.jetpackpokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository  @Inject constructor(
    private val api: PokeAPI
) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred.")
        }

        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred.")
        }

        return Resource.Success(response)
    }
}