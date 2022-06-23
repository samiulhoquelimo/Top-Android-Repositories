package com.brainstation23.topandroidrepositories.service.initializer

import android.content.Context
import androidx.startup.Initializer
import com.brainstation23.topandroidrepositories.BuildConfig
import com.brainstation23.topandroidrepositories.utils.logger.AppLogger

class AppLoggerInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        if (BuildConfig.DEBUG) {
            AppLogger.init()
        }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
