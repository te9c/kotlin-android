package com.example.rickandmortyapp.domain.repository

import com.example.rickandmortyapp.domain.entity.CharacterEntity

interface IRickRepository {
    suspend fun getAllCharacters(forceRefresh: Boolean = false): List<CharacterEntity>
}