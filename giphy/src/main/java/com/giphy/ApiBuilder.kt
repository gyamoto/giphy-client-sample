package com.giphy

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

/**
 * https://developers.giphy.com/docs/
 */
class ApiBuilder {

    companion object {

        fun build() = Retrofit.Builder()
                .baseUrl(Const.GIPHY_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(buildClient())
                .build()
                .create(Api::class.java)

        private fun buildClient() = OkHttpClient.Builder()
                .addInterceptor(
                        HttpLoggingInterceptor {
                            Timber.i("Giphy: $it")
                        }.setLevel(BuildType.LOG_LEVEL)
                )
                .build()
    }
}
