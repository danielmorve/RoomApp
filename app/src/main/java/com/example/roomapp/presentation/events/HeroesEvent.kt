package com.example.roomapp.presentation.events

sealed class HeroesEvent {
    data class OnGetHeroes(val name: String) : HeroesEvent()

    data class OnDeleteHero(val id: Int) : HeroesEvent()
}