package com.example.rickandmortyapp.data.common.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rickandmortyapp.data.model.CharacterModel
import com.example.rickandmortyapp.data.service.CharactersDao

@Database(
    entities = [CharacterModel::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun charactersDao(): CharactersDao

    companion object {
        const val DATABASE_NAME = "characters.db"
    }
}