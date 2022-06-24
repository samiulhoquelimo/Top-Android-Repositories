package com.brainstation23.topandroidrepositories.ui.base.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.brainstation23.topandroidrepositories.R
import com.brainstation23.topandroidrepositories.utils.NetworkUtils
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import es.dmoral.toasty.Toasty

abstract class DaggerActivity : DaggerAppCompatActivity(), MVPView {

    protected abstract fun getLayoutResourceId(): View?

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        getLayoutResourceId()?.let { setContentView(it) }
        super.onCreate(savedInstanceState)
    }

    override fun success(uiText: UiText) {
        Toasty.success(applicationContext, getResString(uiText), Toast.LENGTH_SHORT, true)
            .show()
    }

    override fun error(uiText: UiText) {
        Toasty.error(applicationContext, getResString(uiText), Toast.LENGTH_SHORT, true)
            .show()
    }

    override fun apiError(error: String?) {
        error?.let { message ->
            error(UiText.DynamicString(message))
        } ?: error(UiText.StringResource(R.string.api_default_error))
    }

    override fun noInternetAlert() {
        error(UiText.StringResource(R.string.no_network_message))
    }

    override fun isNetworkConnected(): Boolean = NetworkUtils.isNetworkConnected(this)

    override fun getResString(uiText: UiText): String = uiText.asString(this)
}

