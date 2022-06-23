package com.brainstation23.topandroidrepositories.service.initializer

import android.content.Context
import androidx.startup.Initializer
import com.facebook.stetho.Stetho
import com.brainstation23.topandroidrepositories.utils.extension.debugMode

class StethoInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        debugMode { Stetho.initializeWithDefaults(context) }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
