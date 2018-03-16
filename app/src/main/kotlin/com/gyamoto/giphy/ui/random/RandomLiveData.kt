package com.gyamoto.giphy.ui.random

import android.arch.lifecycle.LiveData
import com.gyamoto.api.Api
import com.gyamoto.api.model.RandomResponse
import com.gyamoto.giphy.architecturecomponent.Resource
import com.gyamoto.db.Store
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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
