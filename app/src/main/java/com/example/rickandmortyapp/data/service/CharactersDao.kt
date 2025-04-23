package com.example.rickandmortyapp.data.service

import androidx.room.Dao
import androidx.room.Query
import com.example.rickandmortyapp.data.model.CharacterModel

@Dao
interface CharactersDao {
    @Query("SELECT * FROM characters")
    suspend fun getAllCharacters(): List<CharacterModel>

    @Query("SELECT * FROM characters WHERE id = :id")
    suspend fun getCharactersById(id: String): CharacterModel
}