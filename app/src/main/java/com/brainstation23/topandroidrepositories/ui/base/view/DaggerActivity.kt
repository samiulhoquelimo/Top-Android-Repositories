package com.brainstation23.topandroidrepositories.ui.base.view

import android.os.Bundle
import android.view.View
import com.brainstation23.topandroidrepositories.utils.NetworkUtils
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity

abstract class DaggerActivity : DaggerAppCompatActivity(), MVPView {

    protected abstract fun getLayoutResourceId(): View?

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        getLayoutResourceId()?.let { setContentView(it) }
        super.onCreate(savedInstanceState)
    }

    override fun isNetworkConnected(): Boolean = NetworkUtils.isNetworkConnected(this)

    override fun getResString(uiText: UiText): String = uiText.asString(this)
}

