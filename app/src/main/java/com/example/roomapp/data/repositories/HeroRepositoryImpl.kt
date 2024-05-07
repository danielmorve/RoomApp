package com.example.roomapp.data.repositories

import com.example.roomapp.data.dao.HeroDao
import com.example.roomapp.domain.models.Hero
import com.example.roomapp.domain.respositories.HeroRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HeroRepositoryImpl @Inject constructor(
    private val heroDao: HeroDao
) : HeroRepository {
    override suspend fun getAllHeroes() : Flow<List<Hero>>{
     return heroDao.getAllHeroes()
    }
}