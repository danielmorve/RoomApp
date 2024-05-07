package com.example.roomapp.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "hero")
data class Hero(@PrimaryKey(autoGenerate = true) val id: Int, val name: String, val imageUrl: String){
    companion object {
        val heroes = listOf<Hero>(
            Hero(
                1,
                "Spiderman",
                "https://www.superherodb.com/gallery/075/839/83957.webp"
            ),
Hero(
                2,
                "Ironman",
                "https://www.superherodb.com/gallery/075/807/80764.webp"
            ),
Hero(
                3,
                "Hulk",
                "https://www.superherodb.com/gallery/075/63/6383.webp"
            ),
Hero(
                4,
                "Thor",
                "https://www.superherodb.com/gallery/075/803/80392.webp"
            ),
        )
    }
}
