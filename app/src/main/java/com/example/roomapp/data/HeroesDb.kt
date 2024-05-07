package com.example.roomapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomapp.data.dao.HeroDao
import com.example.roomapp.domain.models.Hero

@Database(entities = [Hero::class], version =1)
abstract class HeroesDb : RoomDatabase() {
    abstract fun heroDao(): HeroDao
}