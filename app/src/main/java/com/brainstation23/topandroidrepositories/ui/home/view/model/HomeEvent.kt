package com.brainstation23.topandroidrepositories.ui.home.view.model

sealed class HomeEvent {
    object Home : HomeEvent()
    data class Details(val id: Int) : HomeEvent()
}