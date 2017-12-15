package com.kyamamoto.kodein

import android.app.Application
import timber.log.Timber

/**
 * Created by kyamamoto on 2017/11/07.
 */
class KodeinApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}
