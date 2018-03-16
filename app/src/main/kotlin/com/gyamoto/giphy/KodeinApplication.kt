package com.gyamoto.giphy

import android.app.Application
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.android.autoAndroidModule
import com.github.salomonbrys.kodein.lazy
import com.gyamoto.giphy.domain.domainModule
import com.gyamoto.db.PersistentRandom
import timber.log.Timber

class KodeinApplication : Application(), KodeinAware {

    override val kodein by Kodein.lazy {
        import(autoAndroidModule(this@KodeinApplication))
        import(domainModule)
    }

    override fun onCreate() {
        super.onCreate()

        // Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        PersistentRandom.init(this)
    }

}
