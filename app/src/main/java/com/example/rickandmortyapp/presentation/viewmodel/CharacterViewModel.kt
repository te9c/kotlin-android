package com.example.rickandmortyapp.presentation.viewmodel

import com.example.rickandmortyapp.domain.entity.CharacterEntity
import com.example.rickandmortyapp.domain.repository.IRickRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CharacterViewModel(
    private val repository: IRickRepository
) {
    private var currentPage = 1
    private val _hasMore = MutableStateFlow(true)
    val hasMore: StateFlow<Boolean> = _hasMore.asStateFlow()
    private val _characters = MutableStateFlow(emptyList<CharacterEntity>())

    val characters: StateFlow<List<CharacterEntity>> = _characters.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _isError = MutableStateFlow(false)
    val isError: StateFlow<Boolean> = _isError.asStateFlow()

    suspend fun loadCharacters(forceRefresh: Boolean = false) {
        if (forceRefresh) {
            currentPage = 1
            _hasMore.value = true
        }
        if (!_hasMore.value) return

        _isLoading.value = true
        _isError.value = false
        delay(1000) // for debugging purposes
        try {
            val charactersList = repository.getAllCharacters(currentPage, forceRefresh)
            _characters.value = if (forceRefresh) charactersList else _characters.value + charactersList
            _hasMore.value = charactersList.isNotEmpty()
            if (charactersList.isNotEmpty()) currentPage++
        } catch (e: Exception) {
            _isError.value = true
        } finally {
            _isLoading.value = false
        }
    }
}