package com.gyamoto.db

import android.app.Application
import com.facebook.stetho.Stetho

class PersistentRandom {

    companion object {

        fun init(context: Application) {
            Stetho.initializeWithDefaults(context)
        }
    }
}
