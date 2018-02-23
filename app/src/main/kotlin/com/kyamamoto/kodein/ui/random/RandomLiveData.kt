package com.kyamamoto.kodein.ui.random

import android.arch.lifecycle.LiveData
import com.kyamamoto.giphy.Api
import com.kyamamoto.giphy.model.RandomResponse
import com.kyamamoto.kodein.architecturecomponent.Resource
import com.kyamamoto.persistentrandom.Store
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by kyamamoto on 2018/02/05.
 */
class RandomLiveData(
        private val api: Api,
        private val store: Store<RandomResponse>
) : LiveData<Resource<RandomResponse>>() {

    init {
        store.item?.let {
            value = Resource.success(it)
        } ?: run {
            request()
        }
    }

    fun request() {
        value = Resource.progress(value?.response)

        api.random()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .map {
                    store.item = it
                    it
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    value = Resource.success(it)
                }, {
                    value = Resource.error(value?.response, it)
                })
    }
}
