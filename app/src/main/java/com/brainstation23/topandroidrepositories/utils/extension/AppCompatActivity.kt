package com.brainstation23.topandroidrepositories.utils.extension

import com.brainstation23.topandroidrepositories.BuildConfig
import com.google.gson.GsonBuilder

inline fun debugMode(block: () -> Unit) {
    if (BuildConfig.DEBUG) {
        block()
    }
}