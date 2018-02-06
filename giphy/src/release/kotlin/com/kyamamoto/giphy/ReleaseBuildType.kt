package com.kyamamoto.giphy

import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by kyamamoto on 2017/11/08.
 */
class ReleaseBuildType : BuildTypeConfig {

    override val apiKey = "HAgW7cCO48PXdJSSeoo7Dq5tttTu3M8r"

    override val okHttpLogLevel = HttpLoggingInterceptor.Level.NONE

    override val androidLogLevel = null
}
