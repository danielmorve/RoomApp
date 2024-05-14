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
Hero(
                5,
                "Captain America",
                "https://www.superherodb.com/gallery/075/39/3955.webp"
            ),
            Hero(
                6,
                "Superman",
                "https://www.superherodb.com/gallery/075/847/84742.webp"
            ),
            Hero(
                7,
                "Batman",
                "https://www.superherodb.com/gallery/075/46/4692.webp"
            ),
            Hero(
                8,
                "Wonder Woman",
                "https://www.superherodb.com/gallery/075/827/82742.webp"
            ),
            Hero(
                9,
                "Flash",
                "https://www.superherodb.com/gallery/075/308/30830.webp"
            ),
            Hero(
                10,
                "Green Lantern",
                "https://www.superherodb.com/gallery/075/50/5016.webp"
            ),

        )
    }
}
