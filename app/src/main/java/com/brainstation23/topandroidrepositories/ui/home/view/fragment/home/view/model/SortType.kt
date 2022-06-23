package com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.view.model

sealed class SortType(val type: Int) {
    object None : SortType(0)
    object Date : SortType(1)
    object Star : SortType(2)
}
