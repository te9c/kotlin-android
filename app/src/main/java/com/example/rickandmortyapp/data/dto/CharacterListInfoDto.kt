package com.example.rickandmortyapp.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CharacterListInfoDto(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)
