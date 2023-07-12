package com.drcmind.androidretrofitroomjetpackcompose.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [JokeEntity::class], version = 1)
abstract class JokesDatabase : RoomDatabase() {
    abstract fun jokeDao() : JokesDao
}