package com.example.rickandmortyapp.data.service

import com.example.rickandmortyapp.data.common.api.NetworkModule
import com.example.rickandmortyapp.data.dto.CharacterDto
import com.example.rickandmortyapp.data.dto.CharacterListDto
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object RickApiService {
    private const val BASE_URL = "https://rickandmortyapi.com/api"

    suspend fun getAllCharacters(): CharacterListDto {
        return NetworkModule.publicClient.get("$BASE_URL/character").body()
    }

    suspend fun getCharacterById(id: Int): CharacterDto {
        return NetworkModule.publicClient.get("$BASE_URL/character/$id").body()
    }
}