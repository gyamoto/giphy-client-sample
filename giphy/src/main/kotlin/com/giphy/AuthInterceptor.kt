package com.giphy

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by kyamamoto on 2018/01/24.
 */
class AuthInterceptor(private val buildTypeConfig: BuildTypeConfig) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val url = chain.request().url().newBuilder()
                .setQueryParameter("api_key", buildTypeConfig.apiKey)
                .build()

        val request = chain.request().newBuilder()
                .url(url)
                .build()

        return chain.proceed(request)
    }
}
