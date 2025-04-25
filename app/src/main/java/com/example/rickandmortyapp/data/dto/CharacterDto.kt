package com.example.rickandmortyapp.data.dto

import kotlinx.serialization.Serializable

// This is what server is responding
@Serializable
data class CharacterDto(
    val id: Int,
    val name: String,
    val status: String,
    val gender: String,
    val image: String,
    val species: String
)