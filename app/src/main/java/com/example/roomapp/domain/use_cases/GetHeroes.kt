package com.example.roomapp.domain.use_cases

import com.example.roomapp.domain.models.Hero
import com.example.roomapp.domain.respositories.HeroRepository
import kotlinx.coroutines.flow.Flow

class GetHeroes (
    private val repository: HeroRepository
) {

    suspend operator fun invoke(): Flow<List<Hero>>{
        return repository.getAllHeroes()
    }
}