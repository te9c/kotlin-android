package com.example.rickandmortyapp.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CharacterListDto(
    val info: CharacterListInfoDto,
    val results: List<CharacterDto>
)