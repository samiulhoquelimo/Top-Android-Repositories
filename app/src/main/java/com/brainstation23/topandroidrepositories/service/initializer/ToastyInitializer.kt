package com.brainstation23.topandroidrepositories.service.initializer

import android.content.Context
import androidx.core.content.res.ResourcesCompat
import androidx.startup.Initializer
import com.brainstation23.topandroidrepositories.R
import es.dmoral.toasty.Toasty

class ToastyInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        val typeface = ResourcesCompat.getFont(context.applicationContext, R.font.depth_700)
        val config = Toasty.Config.getInstance()
            .allowQueue(false)
        typeface?.let { face -> config.setToastTypeface(face) }
        config.apply()
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
