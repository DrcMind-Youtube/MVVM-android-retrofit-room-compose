package com.drcmind.androidretrofitroomjetpackcompose.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface JokesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addJoke(jokesEntity: JokeEntity)

    @Query("SELECT * FROM joke_entity ORDER BY RANDOM() LIMIT 1")
    suspend fun getRandomJoke() : JokeEntity

}