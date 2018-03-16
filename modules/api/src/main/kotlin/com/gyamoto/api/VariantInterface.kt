package com.gyamoto.api

import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

interface SourceType {

    fun build(buildType: BuildTypeConfig): Api
}

interface BuildTypeConfig {

    val apiKey: String

    val okHttpLogLevel: HttpLoggingInterceptor.Level

    val androidLogLevel: Int?

    fun log(message: String) {
        androidLogLevel?.let { Timber.tag(Api.TAG).log(it, message) }
    }

    fun createInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor({ log(it) })
                .apply { level = okHttpLogLevel }
    }
}
