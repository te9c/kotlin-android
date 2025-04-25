package com.example.rickandmortyapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterModel(
    @PrimaryKey val id: Int,
    val name: String,
    val image: String,
    val species: String,
    val status: String
)