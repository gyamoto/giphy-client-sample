package com.kyamamoto.giphy

import io.reactivex.schedulers.Schedulers.io
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by kyamamoto on 2018/01/24.
 */
class NetworkApi : SourceType {

    override fun build(buildType: BuildTypeConfig): Api = Retrofit.Builder()
            .baseUrl(Api.ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                    buildClient(
                            AuthInterceptor(buildType),
                            buildType.createInterceptor()))
            .addCallAdapterFactory(
                    RxJava2CallAdapterFactory.createWithScheduler(io()))
            .build()
            .create(Api::class.java)

    private fun buildClient(
            authInterceptor: AuthInterceptor,
            loggingInterceptor: okhttp3.logging.HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(authInterceptor)
                .addInterceptor(loggingInterceptor)
                .build()
    }
}
