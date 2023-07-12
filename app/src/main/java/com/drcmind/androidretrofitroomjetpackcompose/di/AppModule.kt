package com.drcmind.androidretrofitroomjetpackcompose.di

import android.content.Context
import androidx.room.Room
import com.drcmind.androidretrofitroomjetpackcompose.data.datasource.local.JokesDao
import com.drcmind.androidretrofitroomjetpackcompose.data.datasource.local.JokesDatabase
import com.drcmind.androidretrofitroomjetpackcompose.data.datasource.remote.JokesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit{
        return Retrofit
            .Builder()
            .baseUrl("https://geek-jokes.sameerkumar.website/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesGeekJokesApi(retrofit: Retrofit) : JokesApi{
        return retrofit.create(JokesApi::class.java)
    }


    @Singleton
    @Provides
    fun providesRoomDatabase(@ApplicationContext context : Context) : JokesDatabase{
        return Room.databaseBuilder(
            context.applicationContext,
            JokesDatabase::class.java,
            "Jokes.db"
            ).build()
    }

    @Provides
    fun providesJokeDao(database: JokesDatabase) : JokesDao{
        return database.jokeDao()
    }
}