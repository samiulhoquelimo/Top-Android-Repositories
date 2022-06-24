package com.brainstation23.topandroidrepositories.service.initializer

import android.content.Context
import androidx.startup.Initializer
import com.brainstation23.topandroidrepositories.utils.extension.debugMode
import timber.log.Timber

class TimberInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        debugMode {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
