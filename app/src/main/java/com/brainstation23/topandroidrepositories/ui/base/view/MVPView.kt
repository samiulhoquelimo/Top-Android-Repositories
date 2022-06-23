package com.brainstation23.topandroidrepositories.ui.base.view

interface MVPView {

    fun isNetworkConnected(): Boolean

    fun getResString(uiText: UiText): String
}