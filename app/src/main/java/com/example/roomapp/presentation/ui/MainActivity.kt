package com.example.roomapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.roomapp.R
import com.example.roomapp.domain.models.Hero
import com.example.roomapp.presentation.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var heroesRecyclerView: RecyclerView
    private val heroes = mutableListOf<Hero>()
    private val mainViewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        heroesRecyclerView = findViewById(R.id.rv_heroes)
    }
}