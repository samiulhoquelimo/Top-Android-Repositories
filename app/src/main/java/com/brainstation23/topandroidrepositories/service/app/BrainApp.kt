package com.brainstation23.topandroidrepositories.service.app

import android.app.Application
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.gsonparserfactory.GsonParserFactory
import com.brainstation23.topandroidrepositories.di.component.DaggerAppComponent
import com.brainstation23.topandroidrepositories.ui.home.view.model.HomeEvent
import com.google.gson.Gson
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import okhttp3.OkHttpClient
import javax.inject.Inject

class BrainApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    internal lateinit var okHttpClient: OkHttpClient

    @Inject
    internal lateinit var gson: Gson

    private val factory by lazy { GsonParserFactory(gson) }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    companion object {
        var navEvent: HomeEvent = HomeEvent.Home
    }

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

        AndroidNetworking.initialize(applicationContext, okHttpClient)
        AndroidNetworking.setParserFactory(factory)
    }
}