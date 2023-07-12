package com.drcmind.androidretrofitroomjetpackcompose.domain.model

import com.drcmind.androidretrofitroomjetpackcompose.data.datasource.local.JokeEntity

data class JokeResponse(
    val joke : String
)

fun JokeResponse.toJokeEntity() : JokeEntity{
    return JokeEntity(joke = this.joke, isFavorite = false)
}
