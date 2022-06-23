package com.brainstation23.topandroidrepositories.di.component

import android.app.Application
import com.brainstation23.topandroidrepositories.di.builder.ActivityBuilder
import com.brainstation23.topandroidrepositories.di.builder.DialogBuilder
import com.brainstation23.topandroidrepositories.di.builder.FragmentBuilder
import com.brainstation23.topandroidrepositories.di.module.AppModule
import com.brainstation23.topandroidrepositories.service.app.BrainApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        (AndroidInjectionModule::class),
        (AppModule::class),
        (ActivityBuilder::class),
        (FragmentBuilder::class),
        (DialogBuilder::class)
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: BrainApp)
}