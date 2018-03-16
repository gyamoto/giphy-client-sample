package com.gyamoto.api

import okhttp3.Interceptor
import okhttp3.Response

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
