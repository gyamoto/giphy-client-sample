package com.giphy

import android.util.Log
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by kyamamoto on 2017/11/08.
 */
class DebugBuildType : BuildTypeConfig {

    override val apiKey = "HAgW7cCO48PXdJSSeoo7Dq5tttTu3M8r"

    override val okHttpLogLevel = HttpLoggingInterceptor.Level.BASIC

    override val androidLogLevel = Log.INFO
}
