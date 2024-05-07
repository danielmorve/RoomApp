package com.example.roomapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.roomapp.data.HeroesDb
import com.example.roomapp.data.dao.HeroDao
import com.example.roomapp.data.repositories.HeroRepositoryImpl
import com.example.roomapp.domain.models.Hero
import com.example.roomapp.domain.respositories.HeroRepository
import com.example.roomapp.domain.use_cases.GetHeroes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideString() : String {
        return "Hello Dagger Hilt"
    }

    @Volatile
    private var INSTANCE : HeroesDb? =null

    @Provides
    @Singleton
    fun provideHeroesDb(@ApplicationContext context: Context) : HeroesDb{
        return INSTANCE ?: synchronized(this){
            val instance = INSTANCE
            if (instance != null){
                instance
            }
            else{
                val callback = object : RoomDatabase.Callback(){
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        CoroutineScope(Dispatchers.IO).launch{
                            val db = INSTANCE ?: return@launch
                            val heroDao = db.heroDao()
                            populateDatabase(heroDao)
                        }
                    }
                    suspend fun populateDatabase(heroDao: HeroDao) {
                        val hero = Hero.heroes
                        heroDao.insertAll(hero)
                    }
                }
                Room.databaseBuilder(context.applicationContext,HeroesDb::class.java, "heroes_db").addCallback(callback).build()
                    .also {
                        INSTANCE = it
                    }
            }
        }

    }

    @Provides
    @Singleton
    fun provideHeroRepository(db: HeroesDb) : HeroRepository {
        return HeroRepositoryImpl(db.heroDao())
    }

    @Provides
    @Singleton
    fun provideGetProducts(repository: HeroRepository) : GetHeroes {
        return GetHeroes(repository)
    }
}