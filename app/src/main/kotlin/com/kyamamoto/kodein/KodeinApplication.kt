package com.kyamamoto.kodein

import android.app.Application
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.android.autoAndroidModule
import com.github.salomonbrys.kodein.lazy
import com.kyamamoto.kodein.domain.domainModule
import com.kyamamoto.persistentrandom.PersistentRandom
import timber.log.Timber

/**
 * Created by kyamamoto on 2017/11/07.
 */
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
