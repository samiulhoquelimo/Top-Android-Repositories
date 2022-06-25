package com.brainstation23.topandroidrepositories.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.androidnetworking.interceptors.HttpLoggingInterceptor.Level
import com.brainstation23.topandroidrepositories.BuildConfig
import com.brainstation23.topandroidrepositories.data.database.AppDatabase
import com.brainstation23.topandroidrepositories.data.database.repository.git_repository.GitRepositoryRepo
import com.brainstation23.topandroidrepositories.data.database.repository.git_repository.GitRepositoryRepository
import com.brainstation23.topandroidrepositories.data.network.ApiHelper
import com.brainstation23.topandroidrepositories.data.network.AppApiHelper
import com.brainstation23.topandroidrepositories.data.preferences.AppPreferenceHelper
import com.brainstation23.topandroidrepositories.data.preferences.PreferenceHelper
import com.brainstation23.topandroidrepositories.di.PackageName
import com.brainstation23.topandroidrepositories.di.PreferenceInfo
import com.brainstation23.topandroidrepositories.di.VersionName
import com.brainstation23.topandroidrepositories.utils.AppConstants
import com.brainstation23.topandroidrepositories.utils.NetworkConstants
import com.brainstation23.topandroidrepositories.utils.SchedulerProvider
import com.brainstation23.topandroidrepositories.utils.extension.debugMode
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import okhttp3.OkHttpClient
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, AppConstants.DB_NAME)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()

    @Provides
    @PackageName
    internal fun providePackageName(): String = BuildConfig.APPLICATION_ID

    @Provides
    @VersionName
    internal fun provideVersionName(): String = BuildConfig.VERSION_NAME

    @Provides
    @PreferenceInfo
    internal fun providePrefFileName(): String = AppConstants.PREF_NAME

    @Provides
    @Singleton
    internal fun providePrefHelper(appPreferenceHelper: AppPreferenceHelper):
            PreferenceHelper = appPreferenceHelper

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

    @Provides
    @Singleton
    internal fun provideOkHttpClient(
        @PackageName packageName: String,
        @VersionName versionName: String
    ): OkHttpClient = with(OkHttpClient().newBuilder()) {
        addInterceptor {
            val modifiedRequest = it.request().newBuilder()
                .addHeader(NetworkConstants.ACCEPT, NetworkConstants.APPLICATION_JSON)
                .build()
            it.proceed(modifiedRequest)
        }
        addNetworkInterceptor { chain ->
            val req = chain.request().newBuilder()
                .header(NetworkConstants.PACKAGE, packageName)
                .header(NetworkConstants.VERSION, versionName)
                .build()
            chain.proceed(req)
        }
        debugMode {
            addNetworkInterceptor(StethoInterceptor())
            addNetworkInterceptor(HttpLoggingInterceptor { message ->
                Timber.tag(NetworkConstants.API).d(message)
            }.apply { level = Level.BODY })
        }
        connectTimeout(NetworkConstants.TIMEOUT_CONNECTION, TimeUnit.SECONDS)
        readTimeout(NetworkConstants.TIMEOUT_READ, TimeUnit.SECONDS)
        writeTimeout(NetworkConstants.TIMEOUT_WRITE, TimeUnit.SECONDS)
        build()
    }

    @Provides
    internal fun provideGson(): Gson = GsonBuilder().serializeNulls().create()

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()

    @Provides
    @Singleton
    internal fun provideGitRepositoryRepoHelper(appDatabase: AppDatabase): GitRepositoryRepo =
        GitRepositoryRepository(appDatabase.gitRepositoryDao())
}