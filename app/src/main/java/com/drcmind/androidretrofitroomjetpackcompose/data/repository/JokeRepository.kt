package com.drcmind.androidretrofitroomjetpackcompose.data.repository

import com.drcmind.androidretrofitroomjetpackcompose.data.datasource.local.JokesDao
import com.drcmind.androidretrofitroomjetpackcompose.data.datasource.remote.JokesApi
import com.drcmind.androidretrofitroomjetpackcompose.domain.model.toJokeEntity
import com.drcmind.androidretrofitroomjetpackcompose.util.Result
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class JokeRepository @Inject constructor(
    private val dao: JokesDao,
    private val api: JokesApi
) {
    fun getRandomJoke() = flow {
        emit(Result.Loading())
        val remoteJoke = api.getRandomJoke().body()
        dao.addJoke(remoteJoke!!.toJokeEntity())
        emit(Result.Success(remoteJoke.joke))
    }.catch { cause ->
        val localJoke = dao.getRandomJoke()
        emit(Result.Error(message = cause.message!!, data = localJoke.joke))
    }
}