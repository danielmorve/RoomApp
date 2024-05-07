package com.example.roomapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomapp.domain.use_cases.GetHeroes
import com.example.roomapp.presentation.states.HeroState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val prueba: String,
    private val getHeroes: GetHeroes
) : ViewModel() {
    private val _state = MutableStateFlow((HeroState()))
    val state = _state.asStateFlow()
    private val _uiEvent = Channel<String> ()
    val uiEvent = _uiEvent.receiveAsFlow()


fun getString() = prueba

    init {
        loadHeroes()
    }

    private fun loadHeroes() {
        viewModelScope.launch {
            try {
                getHeroes().collect(){
                    _state.value = HeroState(it)
                }
            } catch (e: Exception) {
                Log.i("MainViewModel", "Error: ${e.message}")
            }
        }
    }

}