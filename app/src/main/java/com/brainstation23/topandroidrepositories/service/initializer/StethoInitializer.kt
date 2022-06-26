package com.brainstation23.topandroidrepositories.service.initializer

import android.content.Context
import androidx.startup.Initializer
import com.brainstation23.topandroidrepositories.utils.extension.debugMode
import com.facebook.stetho.Stetho

class StethoInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        debugMode { Stetho.initializeWithDefaults(context) }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
