package com.giphy

import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by kyamamoto on 2017/11/08.
 */
class BuildType {

    companion object {

        val LOG_LEVEL = HttpLoggingInterceptor.Level.BODY
    }
}
