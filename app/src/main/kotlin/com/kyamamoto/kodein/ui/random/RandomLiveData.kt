package com.kyamamoto.kodein.ui.random

import android.arch.lifecycle.LiveData
import com.kyamamoto.giphy.ApiBuilder
import com.kyamamoto.giphy.model.RandomResponse
import com.kyamamoto.kodein.architecturecomponent.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by kyamamoto on 2018/02/05.
 */
class RandomLiveData : LiveData<Resource<RandomResponse>>() {

    private val api = ApiBuilder.build()

    init {
        request()
    }

    fun request() {
        value = Resource.progress(value?.response)

        api.random()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    value = Resource.success(it)
                }, {
                    value = Resource.error(value?.response, it)
                })
    }
}
