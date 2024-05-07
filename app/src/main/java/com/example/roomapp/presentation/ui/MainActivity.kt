package com.example.roomapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomapp.R
import com.example.roomapp.domain.adapters.HeroAdapter
import com.example.roomapp.domain.models.Hero
import com.example.roomapp.presentation.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var heroesRecyclerView: RecyclerView
    private val heroes = mutableListOf<Hero>()
    private val mainViewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        heroesRecyclerView = findViewById(R.id.rv_heroes)
        observeState()
    }

    private fun observeState() {

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {

                    mainViewModel.state.collect {
                        Log.i("Heroes", it.heroes.toString())
                        heroesRecyclerView = findViewById(R.id.rv_heroes)
                        heroesRecyclerView.adapter = HeroAdapter(it.heroes)
                        heroesRecyclerView.layoutManager = LinearLayoutManager(
                            this@MainActivity,
                            LinearLayoutManager.VERTICAL,
                            false
                        )
                    }
            }
        }
    }
}