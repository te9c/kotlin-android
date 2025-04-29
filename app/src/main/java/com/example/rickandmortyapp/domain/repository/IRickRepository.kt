package com.example.rickandmortyapp.domain.repository

import com.example.rickandmortyapp.domain.entity.CharacterEntity

interface IRickRepository {
    suspend fun getAllCharacters(page: Int, forceRefresh: Boolean = false): List<CharacterEntity>
}