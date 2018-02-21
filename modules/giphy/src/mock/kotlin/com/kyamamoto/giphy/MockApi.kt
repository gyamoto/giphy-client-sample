package com.kyamamoto.giphy

import com.kyamamoto.giphy.model.PaginationResponse
import com.kyamamoto.giphy.model.RandomResponse
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers.io
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.mock.BehaviorDelegate
import retrofit2.mock.MockRetrofit
import retrofit2.mock.NetworkBehavior

/**
 * Created by kyamamoto on 2018/01/22.
 */
class MockApi : SourceType {

    override fun build(buildType: BuildTypeConfig): Api {

        val builder = Retrofit.Builder()
                .baseUrl(Api.ENDPOINT)
                .client(
                        buildClient(HttpLoggingInterceptor { buildType.log(it) }))
                .addCallAdapterFactory(
                        RxJava2CallAdapterFactory.createWithScheduler(io()))
                .build()
        val behavior = NetworkBehavior.create()
        val mock = MockRetrofit.Builder(builder)
                .networkBehavior(behavior)
                .build()
        val delegate = mock.create(Api::class.java)

        return Mock(delegate)
    }

    private fun buildClient(interceptor: okhttp3.logging.HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
    }
}

class Mock(private val delegate: BehaviorDelegate<Api>) : Api {

    override fun search(
            q: String, limit: Int?, offset: Int?, rating: String?, lang: String?, fmt: String?
    ): Single<PaginationResponse> {

        return delegate.returningResponse(com.kyamamoto.giphy.model.mock.PaginationResponse.mock)
                .search(q, limit, offset, rating, lang, fmt)
    }

    override fun trending(
            limit: Int?, offset: Int?, rating: String?, fmt: String?
    ): Single<PaginationResponse> {

        return delegate.returningResponse(com.kyamamoto.giphy.model.mock.PaginationResponse.mock)
                .trending(limit, offset, rating, fmt)
    }

    override fun random(
            tag: String?, rating: String?, fmt: String?
    ): Single<RandomResponse> {

        return delegate.returningResponse(com.kyamamoto.giphy.model.mock.RandomResponse.mock)
                .random(tag, rating, fmt)
    }

}
