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
    override suspend fun getAllCharacters(page: Int, forceRefresh: Boolean): List<CharacterEntity> {
        val localData = dao.getPage(page)
        if (localData.isEmpty() || forceRefresh) {
            val remoteData = apiService.getAllCharacters(page)
            if (forceRefresh)
                dao.deleteAll()

            dao.insertCharacters(remoteData.results.map { CharacterMapper.mapDtoToModel(it) })
            return remoteData.results.map { CharacterMapper.mapDtoToEntity(it) }
        }

        return localData.map { CharacterMapper.mapModelToEntity(it) }
    }
}