package com.brainstation23.topandroidrepositories.service.initializer

import android.content.Context
import androidx.startup.Initializer
import com.facebook.drawee.backends.pipeline.Fresco

class FrescoInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        Fresco.initialize(context)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
