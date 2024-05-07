package com.example.roomapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomapp.domain.models.Hero
import kotlinx.coroutines.flow.Flow

@Dao
interface HeroDao {
    @Query("SELECT * FROM hero")
    fun getAllHeroes(): Flow<List<Hero>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(heroes: List<Hero>)
}