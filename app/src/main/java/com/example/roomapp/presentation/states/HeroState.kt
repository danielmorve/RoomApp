package com.example.roomapp.presentation.states

import com.example.roomapp.domain.models.Hero

data class HeroState(
    val heroes: List<Hero> = emptyList(),

) {
}