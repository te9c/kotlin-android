package com.example.rickandmortyapp.data.mapper

import com.example.rickandmortyapp.data.dto.CharacterDto
import com.example.rickandmortyapp.domain.entity.CharacterEntity
import android.net.Uri
import androidx.core.net.toUri
import com.example.rickandmortyapp.data.model.CharacterModel

abstract class CharacterMapper {
    companion object {
        fun mapDtoToEntity(dto: CharacterDto): CharacterEntity {
            return CharacterEntity(
                name = dto.name,
                status = dto.status,
                species = dto.species,
                image = dto.image.toUri()
            )
        }

        fun mapModelToEntity(model: CharacterModel): CharacterEntity {
            return CharacterEntity(
                name = model.name,
                status = model.status,
                species = model.species,
                image = model.image.toUri()
            )
        }

        fun mapDtoToModel(dto: CharacterDto): CharacterModel {
            return CharacterModel(
                id = dto.id,
                name = dto.name,
                status = dto.status,
                species = dto.species,
                image = dto.image
            )
        }
    }
}