package com.example.rickandmortyapp.data.repository

import com.example.rickandmortyapp.data.mapper.CharacterMapper
import com.example.rickandmortyapp.data.service.CharactersDao
import com.example.rickandmortyapp.data.service.RickApiService
import com.example.rickandmortyapp.domain.entity.CharacterEntity
import com.example.rickandmortyapp.domain.repository.IRickRepository

class RickRepository(
    private val apiService: RickApiService,
    private val dao: CharactersDao
) : IRickRepository {
    override suspend fun getAllCharacters(forceRefresh: Boolean): List<CharacterEntity> {
        val localData = dao.getAllCharacters()
        if (localData.isEmpty() || forceRefresh) {
            val remoteData = apiService.getAllCharacters()
            return remoteData.result.map { CharacterMapper.mapDtoToEntity(it) }
        }

        return localData.map { CharacterMapper.mapModelToEntity(it) }
    }
}