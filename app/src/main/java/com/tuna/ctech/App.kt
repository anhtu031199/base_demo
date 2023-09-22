package com.tuna.ctech

import android.app.Application
import android.content.Context
import com.tuna.nothingapp.utils.timber.MyDebugTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App : Application() {
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(newBase)
    }

    override fun onCreate() {
        super.onCreate()
//        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(BuildConfig.DEBUG)
        setupTimber()
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(MyDebugTree())
        }
//        else {
//            Timber.plant(CrashlyticsTree())
//        }
    }
}