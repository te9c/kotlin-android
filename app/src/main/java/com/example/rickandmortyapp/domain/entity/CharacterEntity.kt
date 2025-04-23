package com.example.rickandmortyapp.domain.entity

import android.net.Uri

// This is what we want to use in our app
data class CharacterEntity(
    val name: String,
    val status: String,
    val image: Uri
)