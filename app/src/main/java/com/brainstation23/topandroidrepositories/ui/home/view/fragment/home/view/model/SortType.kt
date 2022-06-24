package com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.view.model

sealed class SortType(val type: Int) {
    object None : SortType(0)
    object DateAsc : SortType(1)
    object DateDesc : SortType(2)
    object StarAsc : SortType(3)
    object StarDesc : SortType(4)
}
