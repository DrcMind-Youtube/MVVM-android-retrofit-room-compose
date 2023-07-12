package com.drcmind.androidretrofitroomjetpackcompose.data.datasource.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "joke_entity")
data class JokeEntity(
    @PrimaryKey
    val joke : String,
    val isFavorite : Boolean
)
