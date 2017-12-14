package com.giphy

import io.reactivex.schedulers.Schedulers.io
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

/**
 * https://developers.giphy.com/docs/
 */
class ApiBuilder {

    companion object {

        private const val TAG = "GiphyAPI"

        fun build(): Api = Retrofit.Builder()
                .baseUrl(Const.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(buildClient())
                .addCallAdapterFactory(
                        RxJava2CallAdapterFactory.createWithScheduler(io())
                )
                .build()
                .create(Api::class.java)

        private fun buildClient() = OkHttpClient.Builder()
                .addInterceptor(
                        HttpLoggingInterceptor {
                            Timber.tag(TAG).d(it)
                        }.apply {
                            level = BuildType.LOG_LEVEL
                        }
                )
                .build()
    }
}
