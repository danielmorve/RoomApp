package com.example.roomapp.domain.respositories

import com.example.roomapp.domain.models.Hero
import kotlinx.coroutines.flow.Flow

interface HeroRepository {
    suspend fun getAllHeroes() : Flow<List<Hero>>
}