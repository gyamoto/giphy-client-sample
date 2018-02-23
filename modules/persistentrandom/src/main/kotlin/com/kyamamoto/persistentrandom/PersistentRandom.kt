package com.kyamamoto.persistentrandom

import android.app.Application
import com.facebook.stetho.Stetho

/**
 * Created by kyamamoto on 2018/02/22.
 */
class PersistentRandom {

    companion object {

        fun init(context: Application) {
            Stetho.initializeWithDefaults(context)
        }
    }
}
