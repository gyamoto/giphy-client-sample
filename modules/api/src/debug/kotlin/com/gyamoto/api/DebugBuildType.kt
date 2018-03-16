package com.gyamoto.api

import android.util.Log
import okhttp3.logging.HttpLoggingInterceptor

class DebugBuildType : BuildTypeConfig {

    override val apiKey = "HAgW7cCO48PXdJSSeoo7Dq5tttTu3M8r"

    override val okHttpLogLevel = HttpLoggingInterceptor.Level.BASIC

    override val androidLogLevel = Log.INFO
}
