package com.example.a14hw.entity

sealed class State {
    object Loading : State()
    object Success : State()
    object Error: State()
}